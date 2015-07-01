package font.render;

import com.jogamp.opengl.GL3;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

import font.misc.F3DGraphicalSettings;

class F3DGraphicsEventListener implements GLEventListener{
	
	F3DGraphicalSettings settings;
	
	public F3DGraphicsEventListener(F3DGraphicalSettings s)
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
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4)
	{
			
	}

}
