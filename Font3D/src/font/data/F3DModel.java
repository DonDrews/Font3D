package font.data;

import font.material.F3DMaterial;
import font.misc.F3DErrorManager;

public class F3DModel {
	
	int index;
	F3DVector3 position;
	//in radians!
	float rotation;
	float scale;
	F3DMaterial material;
	
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
}
