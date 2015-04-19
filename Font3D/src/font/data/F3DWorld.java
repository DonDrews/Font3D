package font.data;

import java.util.ArrayList;

import font.misc.F3DErrorManager;

public class F3DWorld {
	
	//errors
	public static final int REMOVE_MODEL_ERROR = 0;
	
	//array of current world lights
	//total of 16 allowed
	F3DLight[] lights = new F3DLight[16];
	
	//array list of models
	ArrayList<F3DModel> models = new ArrayList<F3DModel>();
	
	
	//public constructor
	public F3DWorld()
	{
		//initialize all lights to null
		for(int i = 0; i < 16; i++)
		{
			lights[i] = new F3DLight();
		}
	}
	
	//getting and setting light functions
	public F3DLight getLightAtIndex(int i)
	{
		return this.lights[i];
	}
	
	public void bindLightAtIndex(F3DLight l, int i)
	{
		this.lights[i] = l;
	}
	
	public void bindModel(F3DModel m)
	{
		models.add(m);
		updateIndices();
	}
	
	public void removeModelAtIndex(int i)
	{
		if(i < models.size() && i >= 0)
		{
			models.remove(i);
			updateIndices();
		}
		else
		{
			F3DErrorManager.throwError(REMOVE_MODEL_ERROR);
		}
	}
	
	//update all indices for models
	public void updateIndices()
	{
		for(int i = 0; i < models.size(); i++)
		{
			models.get(i).index = i;
		}
	}

}
