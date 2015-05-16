package font.data;

import java.util.ArrayList;

import font.misc.F3DErrorManager;
import font.misc.F3DGraphicalSettings;

public class F3DWorld {
	
	//array of current world lights
	//total of 16 allowed
	F3DLight[] lights = new F3DLight[16];
	
	//array list of models
	ArrayList<F3DModel> models = new ArrayList<F3DModel>();
	
	//array list of cameras
	ArrayList<F3DCamera> cameras = new ArrayList<F3DCamera>();
	
	//USER SHOULD NOT EDIT
	public F3DGraphicalSettings settings;
	
	
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
			F3DErrorManager.throwError(F3DErrorManager.REMOVE_MODEL_ERROR);
		}
	}
	
	public void bindCamera(F3DCamera c)
	{
		c.settings = this.settings;
		cameras.add(c);
		updateIndices();
	}
	
	public void removeCameraAtIndex(int i)
	{
		if(i < cameras.size() && i >= 0)
		{
			cameras.remove(i);
			updateIndices();
		}
		else
		{
			F3DErrorManager.throwError(F3DErrorManager.REMOVE_CAMERA_ERROR);
		}
	}
	
	//update all indices for models and cameras
	public void updateIndices()
	{
		for(int i = 0; i < models.size(); i++)
		{
			models.get(i).index = i;
		}
		
		for(int i = 0; i < cameras.size(); i++)
		{
			cameras.get(i).index = i;
		}
	}

}
