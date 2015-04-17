package font.data;

public class F3DLight {
	
	F3DVector3 position;
	boolean isNull;
	
	//public constructor
	public F3DLight(F3DVector3 p)
	{
		this.position = p;
	}
	
	//getting and setting functions
	public F3DVector3 getPos()
	{
		return this.position;
	}
	
	public void setPos(F3DVector3 p)
	{
		this.position = p;
	}

}
