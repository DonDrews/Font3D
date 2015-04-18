package font.lights;

import font.data.F3DLight;
import font.data.F3DVector3;

public class F3DPointLight extends F3DLight{
	
	//public constructor (Called by user)
	public F3DPointLight(F3DVector3 position, float strength)
	{
		super(position, F3DLight.TYPE_POINT, strength);
	}
}
