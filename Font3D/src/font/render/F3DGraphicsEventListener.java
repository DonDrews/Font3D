package font.render;

import com.jogamp.opengl.GL3;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

import font.misc.F3DGraphicalSettings;

class F3DGraphicsEventListener implements GLEventListener{
	
	private F3DGraphicalSettings settings;
	private int canvasX;
	private int canvasY;
	
	//GL object arrays
	private int vertexArrays[];
	private int framebuffers[];
	private int renderbuffers[];
	//for use with framebuffers
	private int glTextures[];
	
	public F3DGraphicsEventListener(F3DGraphicalSettings s, int x, int y)
	{
		this.settings = s;
	}

	@Override
	public void display(GLAutoDrawable arg0)
	{
		GL3 gl = (GL3) arg0.getGL();
	}

	@Override
	public void dispose(GLAutoDrawable arg0)
	{
		
	}

	@Override
	public void init(GLAutoDrawable arg0)
	{
		GL3 gl = (GL3) arg0.getGL();
		//disable or enable VSync
		if(settings.vSync)
		{
			gl.setSwapInterval(1);
		}
		
		//enable other GL settings
		gl.glEnable(GL3.GL_DEPTH_TEST);
		gl.glDepthFunc(GL3.GL_LEQUAL);
		
		if(settings.antiAliasing)
		{
			//create framebuffers, renderbuffers, and multisample textures
			gl.glEnable(GL3.GL_MULTISAMPLE);
			
			framebuffers = new int[1];
			glTextures = new int[1];
			renderbuffers = new int[1];
			
			gl.glGenTextures(1, glTextures, 0);
			gl.glBindTexture(GL3.GL_TEXTURE_2D_MULTISAMPLE, glTextures[0]);
			gl.glTexImage2DMultisample(GL3.GL_TEXTURE_2D_MULTISAMPLE, settings.getAntiAliasingLevel(), GL3.GL_RGBA8, canvasX, canvasY, true);
			
			gl.glGenFramebuffers(1, framebuffers, 0);
			gl.glBindFramebuffer(GL3.GL_FRAMEBUFFER, framebuffers[0]);
			gl.glFramebufferTexture2D(GL3.GL_FRAMEBUFFER, GL3.GL_COLOR_ATTACHMENT0, GL3.GL_TEXTURE_2D_MULTISAMPLE, glTextures[0], 0);
		}
		else
		{
			
		}
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4)
	{
			
	}

}
