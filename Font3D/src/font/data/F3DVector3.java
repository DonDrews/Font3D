package font.data;

public class F3DVector3 {
	
	//values
	float x;
	float y;
	float z;
	
	//public constructor
	public F3DVector3(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	//getting and setting functions
	public void setX(float x)
	{
		this.x = x;
	}
	
	public void setY(float y)
	{
		this.y = y;
	}
	
	public void setZ(float z)
	{
		this.z = z;
	}
	
	public float getX()
	{
		return this.x;
	}
	
	public float getY()
	{
		return this.y;
	}
	
	public float getZ()
	{
		return this.z;
	}
	
	//normalizing function 
	//NOTE: Expensive operation, use sparingly
	public void normalize()
	{
		float length = (float) Math.sqrt((x * x) + (y * y) + (z * z));
		x = (x / length);
		y = (y / length);
		z = (z / length);
	}
	
	//to string function required for OBJ loader
	public String toString()
	{
		return x + "," + y + "," + z;
	}

}
