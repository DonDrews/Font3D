package font.misc;

public class F3DGraphicalSettings {
	
	//settings
	public boolean vSync;
	public boolean antiAliasing;
	int antiAliasingLevel;
	public boolean hQShaders;
	int textureFilteringLevel;
	
	//public default settings constructor
	public F3DGraphicalSettings()
	{
		this.vSync = false;
		this.antiAliasing = false;
		this.antiAliasingLevel = 2;
		this.hQShaders = false;
		this.textureFilteringLevel = 2;
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
	
	//getting functions
	public int getAntiAliasingLevel()
	{
		return this.antiAliasingLevel;
	}
	
	public int getTextureFilteringLevel()
	{
		return this.textureFilteringLevel;
	}

}
