package font.data;

import java.util.ArrayList;

public class F3DMesh {
	
	//values
	ArrayList<F3DVector3> vertices = new ArrayList<F3DVector3>();
	ArrayList<F3DVector3> normals = new ArrayList<F3DVector3>();
	ArrayList<Integer> vertexIndices = new ArrayList<Integer>();
	
	//getting functions
	public F3DVector3 getVertexAtIndex(int i)
	{
		return this.vertices.get(i);
	}
	
	public F3DVector3 getNormalAtIndex(int i)
	{
		return this.normals.get(i);
	}
	
	public int getIndexAtIndex(int i)
	{
		return this.vertexIndices.get(i).intValue();
	}

}
