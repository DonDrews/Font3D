package font.material;

import font.misc.F3DErrorManager;

public class F3DMaterial {
	
	//values
	float diffuseStrength;
	float ambientStrength;
	float specularStrength;
	float specularSharpness;
	
	public F3DMaterial(float d, float a, float s, float sSharpness)
	{
		if(d > 0 && d < 1 && a > 0 && a < 1 && s > 0 && s < 1 && sSharpness > 0)
		{
			this.diffuseStrength = d;
			this.ambientStrength = a;
			this.specularStrength = s;
			this.specularSharpness = sSharpness;
		}
		else
		{
			F3DErrorManager.throwError(F3DErrorManager.INVALID_MATERIAL_VALUE_ERROR);
		}
	}
	
	//getting functions
	public float getDiffuseStrength()
	{
		return this.diffuseStrength;
	}
	
	public float getAmbientStrength()
	{
		return this.ambientStrength;
	}
	
	public float getSpecularStrength()
	{
		return this.specularStrength;
	}
	
	public float getSpecularSharpness()
	{
		return this.specularSharpness;
	}

}
