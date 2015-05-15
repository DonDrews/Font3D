package font.vectors;

public class F3DVector2 {
	
	//values
	float x;
	float y;
	
	//public constructor
	public F3DVector2(float x, float y)
	{
		this.x = x;
		this.y = y;
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
	
	public float getX()
	{
		return this.x;
	}
	
	public float getY()
	{
		return this.y;
	}
	
	//normalizing function 
	//NOTE: Expensive operation, use sparingly
	public void normalize()
	{
		float length = (float) Math.sqrt((x * x) + (y * y));
		x = (x / length);
		y = (y / length);
	}

}
