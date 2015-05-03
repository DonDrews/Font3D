package font.misc;

public class F3DGraphicalSettings {
	
	//settings
	public boolean vSync;
	public boolean antiAliasing;
	int antiAliasingLevel;
	public boolean hQShaders;
	int textureFilteringLevel;
	float renderDistance;
	int fieldOfView;
	public boolean calculatePerspective;
	
	//public default settings constructor
	public F3DGraphicalSettings()
	{
		this.vSync = false;
		this.antiAliasing = false;
		this.antiAliasingLevel = 2;
		this.hQShaders = false;
		this.textureFilteringLevel = 2;
		this.calculatePerspective = true;
		this.renderDistance = 500;
		this.fieldOfView = 90;
	}
	
	
	//anti aliasing level setting functions
	public void setAntiAliasing2()
	{
		this.antiAliasingLevel = 2;
	}
	
	public void setAntiAliasing4()
	{
		this.antiAliasingLevel = 4;
	}
	
	public void setAntiAliasing8()
	{
		this.antiAliasingLevel = 8;
	}
	
	//texture filtering level setting functions
	public void setTextureFiltering2()
	{
		this.textureFilteringLevel = 2;
	}
	
	public void setTextureFiltering4()
	{
		this.textureFilteringLevel = 4;
	}
	
	public void setTextureFiltering8()
	{
		this.textureFilteringLevel = 8;
	}
	
	public void setTextureFiltering16()
	{
		this.textureFilteringLevel = 16;
	}
	
	//setting functions
	public void setRenderDistance(float d)
	{
		if(d > 0)
		{
			this.renderDistance = d;
		}
		else
		{
			F3DErrorManager.throwError(F3DErrorManager.INVALID_GRAPHICAL_SETTING_VALUE_ERROR);
		}
	}
	
	public void setFieldOfView(int f)
	{
		if(f < 180 && f > 0)
		{
			this.fieldOfView = f;
		}
		else
		{
			F3DErrorManager.throwError(F3DErrorManager.INVALID_GRAPHICAL_SETTING_VALUE_ERROR);
		}
	}
	
	
	
	//getting functions
	public int getAntiAliasingLevel()
	{
		return this.antiAliasingLevel;
	}
	
	public int getTextureFilteringLevel()
	{
		return this.textureFilteringLevel;
	}
	
	public float getRenderDistance()
	{
		return this.renderDistance;
	}
	
	public int getFieldOfView()
	{
		return this.fieldOfView;
	}

}
