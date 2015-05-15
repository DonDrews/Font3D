package font.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;

import font.misc.F3DErrorManager;
import font.parseOBJ.builder.Build;
import font.parseOBJ.builder.Face;
import font.parseOBJ.builder.FaceVertex;
import font.parseOBJ.parser.Parse;
import font.vectors.F3DVector3;

public class F3DMesh {
	
	//values
	FloatBuffer vertices;
	FloatBuffer normals;
	IntBuffer vertexIndices;
	
	public F3DMesh(File obj)
	{
		this.vertices.clear();
		this.normals.clear();
		this.vertexIndices.clear();
		//parse obj file
		Build builder = new Build();
		try {
			Parse parser = new Parse(builder, obj.getName());
		} catch (FileNotFoundException e) {
			F3DErrorManager.throwError(F3DErrorManager.CANT_FIND_OBJ_ERROR);
		} catch (IOException e) {
			F3DErrorManager.throwError(F3DErrorManager.CANT_READ_FILESYSTEM_ERROR);
		}
		//add info to buffers
		this.build(builder.faces);
	}
	
	//getting functions
	public F3DVector3 getVertexAtIndex(int i)
	{
		return new F3DVector3(this.vertices.get(i * 3), this.vertices.get(i * 3) + 1, this.vertices.get(i * 3) + 2);
	}
	
	public F3DVector3 getNormalAtIndex(int i)
	{
		return new F3DVector3(this.normals.get(i * 3), this.normals.get(i * 3) + 1, this.normals.get(i * 3) + 2);
	}
	
	public int getIndexAtIndex(int i)
	{
		return this.vertexIndices.get(i);
	}
	
	// Written by Sean R. Owens, sean at guild dot net, released to the
	// public domain. Share and enjoy. Since some people argue that it is
	// impossible to release software to the public domain, you are also free
	// to use this code under any version of the GPL, LPGL, Apache, or BSD
	// licenses, or contact me for use of another license.
	
	void build(ArrayList<Face> triangles) {
        //	System.err.println("VBOFactory.build: building a vbo!");

        if (triangles.size() <= 0) {
            throw new RuntimeException("Can not build a VBO if we have no triangles with which to build it.");
        }

        // Now sort out the triangle/vertex indices, so we can use a
        // VertexArray in our VBO.  Note the following is NOT the most efficient way
        // to do this, but hopefully it is clear.  

        // First build a map of the unique FaceVertex objects, since Faces may share FaceVertex objects.
        // And while we're at it, assign each unique FaceVertex object an index as we run across them, storing
        // this index in the map, for use later when we build the "index" buffer that refers to the vertice buffer.
        // And lastly, keep a list of the unique vertice objects, in the order that we find them in.  
        HashMap<FaceVertex, Integer> indexMap = new HashMap<FaceVertex, Integer>();
        int nextVertexIndex = 0;
        ArrayList<FaceVertex> faceVertexList = new ArrayList<FaceVertex>();
        for (Face face : triangles) {
            for (FaceVertex vertex : face.vertices) {
                if (!indexMap.containsKey(vertex)) {
                    indexMap.put(vertex, nextVertexIndex++);
                    faceVertexList.add(vertex);
                }
            }
        }

        // Now build the buffers for the VBO/IBO
        int verticeAttributesCount = nextVertexIndex;
        int indicesCount = triangles.size() * 3;

        int numMissingNormals = 0;
        int numMissingUV = 0;
        System.err.println("VBOFactory.build: Creating buffer of size " + verticeAttributesCount + " vertices at " + 6 + " floats per vertice for a total of " + (verticeAttributesCount * 6) + " floats.");
        this.vertices = FloatBuffer.allocate(verticeAttributesCount * 3);
        this.normals = FloatBuffer.allocate(verticeAttributesCount * 3);
        if (null == this.vertices) {
            System.err.println("VBOFactory.build: ERROR Unable to allocate verticeAttributes buffer of size " + (verticeAttributesCount * 3) + " floats.");
        }
        for (FaceVertex vertex : faceVertexList) {
            this.vertices.put(vertex.v.getX());
            this.vertices.put(vertex.v.getY());
            this.vertices.put(vertex.v.getZ());
            if (vertex.n == null) {
                // @TODO: What's a reasonable default normal?  Maybe add code later to calculate normals if not present in .obj file.
                this.normals.put(1.0f);
                this.normals.put(1.0f);
                this.normals.put(1.0f);
                numMissingNormals++;
            } else {
                this.normals.put(vertex.n.getX());
                this.normals.put(vertex.n.getY());
                this.normals.put(vertex.n.getZ());
            }
        }
        this.vertices.flip();
        this.normals.flip();

        System.err.println("Had " + numMissingNormals + " missing normals and " + numMissingUV + " missing UV coords");

        this.vertexIndices = IntBuffer.allocate(indicesCount);
        for (Face face : triangles) {
            for (FaceVertex vertex : face.vertices) {
                int index = indexMap.get(vertex);
                this.vertexIndices.put(index);
            }
        }
        this.vertexIndices.flip();
    }

}
