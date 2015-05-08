package font.data;

public class F3DTexVector {
	
	//values
	float u;
	float v;
	
	//public constructor
	public F3DTexVector(float u, float v)
	{
		this.u = u;
		this.v = v;
	}
	
	//getting and setting functions
	public void setU(float u)
	{
		this.u = u;
	}
	
	public void setV(float v)
	{
		this.v = v;
	}
	
	public float getU()
	{
		return this.u;
	}
	
	public float getV()
	{
		return this.v;
	}
	
}
