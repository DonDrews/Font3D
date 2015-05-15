package font.lights;

import font.data.F3DLight;
import font.vectors.F3DVector3;

public class F3DSpotLight extends F3DLight{
	
	//class individual values
	F3DVector3 direction;
	float falloff;
	
	//public constructor for user
	public F3DSpotLight(F3DVector3 p, F3DVector3 d, float s, float f)
	{
		super(p, F3DLight.TYPE_SPOTLIGHT, s);
		d.normalize();
		this.direction = d;
		this.falloff = f;
	}
	
	//getting and setting functions
	public F3DVector3 getDirection()
	{
		return this.direction;
	}
	
	public float getFalloff()
	{
		return this.falloff;
	}
	
	public void setDirection(F3DVector3 d)
	{
		this.direction = d;
	}
	
	public void setFalloff(float f)
	{
		this.falloff = f;
	}

}
