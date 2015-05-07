package font.data;

import java.nio.FloatBuffer;

import com.jogamp.opengl.util.PMVMatrix;

import font.misc.F3DErrorManager;

public class F3DCamera {
	
	//values
	F3DVector3 position;
	F3DVector3 lookingAtPosition;
	//in degrees
	float fieldOfView;
	boolean orthographic;
	float orthoWidth;
	float orthoHeight;
	
	FloatBuffer cameraMatrix;
	
	//public constructor (called by user)
	public F3DCamera()
	{
		this.position = new F3DVector3(0, 0, 0);
		this.lookingAtPosition = new F3DVector3(0, 0, -1);
		this.fieldOfView = 90;
		this.orthographic = false;
	}
	
	//getting and setting functions
	public F3DVector3 getPosition()
	{
		return this.position;
	}
	
	public F3DVector3 getLookingAtPosition()
	{
		return this.lookingAtPosition;
	}
	
	public float getFieldOfView()
	{
		return this.fieldOfView;
	}
	
	public float getOrthoWidth()
	{
		return this.orthoWidth;
	}
	
	public float getOrthoHeight()
	{
		return this.orthoHeight;
	}
	
	public void setPosition(F3DVector3 p)
	{
		this.position = p;
	}
	
	public void setLookingAtPosition(F3DVector3 p)
	{
		this.lookingAtPosition = p;
	}
	
	public void setFieldOfView(float f)
	{
		if(f < 180 && f > 0)
		{
			this.fieldOfView = f;
		}
		else
		{
			F3DErrorManager.throwError(F3DErrorManager.INVALID_CAMERA_VALUE_ERROR);
		}
	}
	
	public void setOrthoWidth(float w)
	{
		this.orthoWidth = w;
	}
	
	public void setOrthoHeight(float h)
	{
		this.orthoHeight = h;
	}
	
	//function called each time a value is changed to keep matrix up-to-date
	private void updateCameraMatrix()
	{
		PMVMatrix matrixMaker = new PMVMatrix();
		if(this.orthographic)
		{
			//matrixMaker.glOrthof(0 - (this.orthoWidth / 2), arg1, arg2, arg3, arg4, arg5);
		}
		else
		{
			
		}
	}

}
