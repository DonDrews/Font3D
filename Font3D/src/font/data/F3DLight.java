package font.data;

public class F3DLight {
	
	//type constants
	public static final int TYPE_POINT = 0;
	public static final int TYPE_DIRECTIONAL = 0;
	public static final int TYPE_SPOTLIGHT = 0;
	
	F3DVector3 position;
	boolean isNull;
	int type;
	
	//hidden constructor (only called by subclasses)
	protected F3DLight(F3DVector3 p, int t)
	{
		this.position = p;
		this.type = t;
	}
	
	//hidden constructor (only called by F3DWorld)
	protected F3DLight()
	{
		this.position = new F3DVector3(0.0f, 0.0f, 0.0f);
		this.type = 0;
		this.isNull = true;
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
