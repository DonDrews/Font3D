package font.data;


public class F3DLight {
	
	//type constants
	public static final int TYPE_POINT = 0;
	public static final int TYPE_DIRECTIONAL = 0;
	public static final int TYPE_SPOTLIGHT = 0;
	
	F3DVector3 position;
	boolean isNull;
	int type;
	float strength;
	
	//hidden constructor (only called by subclasses)
	protected F3DLight(F3DVector3 p, int t, float s)
	{
		this.position = p;
		this.type = t;
		this.strength = s;
	}
	
	//hidden constructor (only called by F3DWorld)
	protected F3DLight()
	{
		this.position = new F3DVector3(0.0f, 0.0f, 0.0f);
		this.type = 0;
		this.strength = 0.0f;
		this.isNull = true;
	}
	
	//getting and setting functions
	public F3DVector3 getPos()
	{
		return this.position;
	}
	
	public int getType()
	{
		return this.type;
	}
	
	public float getStrength()
	{
		return this.strength;
	}
	
	public void setPos(F3DVector3 p)
	{
		this.position = p;
	}
	
	public void setStrength(float s)
	{
		this.strength = s;
	}

}
