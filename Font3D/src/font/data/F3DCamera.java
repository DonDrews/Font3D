package font.data;

import java.nio.FloatBuffer;

import com.jogamp.opengl.util.PMVMatrix;

import font.misc.F3DErrorManager;
import font.misc.F3DGraphicalSettings;
import font.vectors.F3DVector3;

public class F3DCamera {
	
	//values
	int index;
	F3DVector3 position;
	F3DVector3 lookingAtPosition;
	F3DVector3 upPosition;
	//in degrees
	float fieldOfView;
	boolean orthographic;
	float orthoWidth;
	float orthoHeight;
	float perspectiveAspectRatio;
	//USER SHOULD NOT EDIT
	F3DGraphicalSettings settings;
	
	FloatBuffer cameraMatrix;
	
	//public constructor (called by user)
	public F3DCamera()
	{
		this.position = new F3DVector3(0, 0, 0);
		this.lookingAtPosition = new F3DVector3(0, 0, -1);
		this.fieldOfView = 90;
		this.orthographic = false;
		this.perspectiveAspectRatio = 1.777777778f;
		this.updateCameraMatrix();
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
	
	public F3DVector3 getUpPosition()
	{
		return this.upPosition;
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
	
	public float getPerspectiveAspectRatio()
	{
		return this.perspectiveAspectRatio;
	}
	
	public void setPosition(F3DVector3 p)
	{
		this.position = p;
		this.updateCameraMatrix();
	}
	
	public void setLookingAtPosition(F3DVector3 p)
	{
		this.lookingAtPosition = p;
		this.updateCameraMatrix();
	}
	
	public void setUpPosition(F3DVector3 p)
	{
		this.upPosition = p;
		this.updateCameraMatrix();
	}
	
	public void setFieldOfView(float f)
	{
		if(f < 180 && f > 0)
		{
			this.fieldOfView = f;
			this.updateCameraMatrix();
		}
		else
		{
			F3DErrorManager.throwError(F3DErrorManager.INVALID_CAMERA_VALUE_ERROR);
		}
	}
	
	public void setOrthoWidth(float w)
	{
		this.orthoWidth = w;
		this.updateCameraMatrix();
	}
	
	public void setOrthoHeight(float h)
	{
		this.orthoHeight = h;
		this.updateCameraMatrix();
	}
	
	public void setPerspectiveAspectRatio(float a)
	{
		if(a > 0)
		{
			this.perspectiveAspectRatio = a;
			this.updateCameraMatrix();
		}
		else
		{
			F3DErrorManager.throwError(F3DErrorManager.INVALID_CAMERA_VALUE_ERROR);
		}
	}
	//function called each time a value is changed to keep matrix up-to-date
	private void updateCameraMatrix()
	{
		PMVMatrix matrixMaker = new PMVMatrix();
		//set up perspective / orthographic matrix
		if(this.orthographic)
		{
			matrixMaker.glOrthof(0 - (this.orthoWidth / 2), 0 + (this.orthoWidth / 2), 0 - (this.orthoHeight / 2), 0 + (this.orthoHeight / 2), 0.01f, settings.getRenderDistance());
		}
		else
		{
			matrixMaker.gluPerspective(this.fieldOfView, this.perspectiveAspectRatio, 0.01f, settings.getRenderDistance());
		}
		//set up view matrix
		matrixMaker.gluLookAt(this.position.getX(), this.position.getY(), this.position.getZ(), this.lookingAtPosition.getX(), this.lookingAtPosition.getY(), this.lookingAtPosition.getZ(), this.upPosition.getX(), this.upPosition.getY(), this.upPosition.getZ());
		
		//move changes to current matrix
		this.cameraMatrix = matrixMaker.glGetMatrixf();
	}

}
