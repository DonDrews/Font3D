package font.lights;

import font.data.F3DLight;
import font.vectors.F3DVector3;

public class F3DDirectionalLight extends F3DLight{
	
	//public constructor called by user
	public F3DDirectionalLight(F3DVector3 direction, float strength)
	{
		super(direction, F3DLight.TYPE_DIRECTIONAL, strength);
	}

}
