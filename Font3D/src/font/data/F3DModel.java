package font.data;

import java.nio.FloatBuffer;

import com.jogamp.opengl.util.PMVMatrix;

import font.material.F3DMaterial;
import font.misc.F3DErrorManager;
import font.vectors.F3DVector3;

public class F3DModel {
	
	int index;
	F3DVector3 position;
	//in radians!
	float rotation;
	float scale;
	F3DMaterial material;
	
	//matrix to be passed into shader
	FloatBuffer matrix;
	
	//mesh for this matrix
	F3DMesh mesh;
	
	public F3DModel(F3DMesh m)
	{
		this.mesh = m;
		this.updateModelMatrix();
	}
	//getting and setting functions
	public int getIndex()
	{
		return this.index;
	}
	
	public F3DVector3 getPosition()
	{
		return this.position;
	}
	
	public float getRotation()
	{
		return this.rotation;
	}
	
	public float getScale()
	{
		return this.scale;
	}
	
	public F3DMaterial getMaterial()
	{
		return this.material;
	}
	
	public void setPosition(F3DVector3 p)
	{
		this.position = p;
	}
	
	public void setRotation(float r)
	{
		if(r < Math.PI * 2 && r  >= 0)
		{
			this.rotation = r;
		}
		else
		{
			F3DErrorManager.throwError(F3DErrorManager.INVALID_MODEL_ROTATION_VALUE_ERROR);
		}
	}
	
	public void setScale(float s)
	{
		this.scale = s;
	}
	
	public void setMaterial(F3DMaterial m)
	{
		this.material = m;
	}
	
	public void setMesh(F3DMesh m)
	{
		this.mesh = m;
	}
	
	public void updateModelMatrix()
	{
		PMVMatrix matrixMaker = new PMVMatrix();
		//rotate last
		matrixMaker.glRotatef((float)Math.toDegrees(this.rotation), 0f, 1f, 0f);
		//position middle
		matrixMaker.glTranslatef(this.position.getX(), this.position.getY(), this.position.getZ());
		//scale first
		matrixMaker.glScalef(this.scale, this.scale, this.scale);
		
		//move changes to current matrix
		this.matrix = matrixMaker.glGetMatrixf();
	}
}
