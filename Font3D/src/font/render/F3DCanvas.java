package font.render;

import com.jogamp.opengl.awt.GLCanvas;

import font.data.F3DWorld;
import font.misc.F3DErrorManager;

public class F3DCanvas extends GLCanvas{
	
	F3DWorld world;
	
	public F3DCanvas(int x, int y, int w, int h)
	{
		this.setBounds(x, y, w, h);
	}
	
	public void bindWorld(F3DWorld w)
	{
		this.world = w;
	}
	
	public void beginRendering()
	{
		if(this.world.equals(null))
		{
			F3DErrorManager.throwError(F3DErrorManager.CANVAS_NO_WORLD_SET_ERROR);
		}
		//TODO: actual rendering stuff
	}
	
	public void stopRendering()
	{
		//TODO: actual stopping rendering stuff
	}

}
