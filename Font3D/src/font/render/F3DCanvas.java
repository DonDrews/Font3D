package font.render;

import java.awt.Graphics2D;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLCapabilitiesImmutable;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.FPSAnimator;

import font.data.F3DWorld;
import font.misc.F3DErrorManager;
import font.misc.F3DGraphicalSettings;

public class F3DCanvas extends GLCanvas{
	
	F3DWorld world;
	F3DGraphicalSettings settings;
	FPSAnimator animator;
	F3DGraphicsEventListener listen;
	
	public F3DCanvas(int x, int y, int w, int h, F3DGraphicalSettings s)
	{
		super((GLCapabilitiesImmutable) new GLCapabilities(GLProfile.get(GLProfile.GL3)));
		if(x < 0 || y < 0 || w < 0 || h < 0)
		{
			F3DErrorManager.throwError(F3DErrorManager.INVALID_CANVAS_SIZE_ERROR);
		}
		else
		{
			this.setBounds(x, y, w, h);
		}
		this.settings = s;
		
		//setup animator and event listener
		this.animator = new FPSAnimator(this.settings.getMaxFPS());
		animator.add(this);
		
		this.listen = new F3DGraphicsEventListener(this.settings, this);
		this.addGLEventListener(this.listen);
	}
	
	public void bindWorld(F3DWorld w)
	{
		w.settings = this.settings;
		this.world = w;
	}
	
	public void beginRendering()
	{
		if(this.world.equals(null))
		{
			F3DErrorManager.throwError(F3DErrorManager.CANVAS_NO_WORLD_SET_ERROR);
		}
		this.animator.start();
	}
	
	public void stopRendering()
	{
		//TODO: actual stopping rendering stuff
	}
	
	//function to be overriden by user
	//graphics is for image to be drawn onto canvas for HUD and sorts
	public Graphics2D eachFrame(Graphics2D g)
	{
		return g;
	}

}
