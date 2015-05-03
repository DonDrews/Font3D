package font.misc;

public class F3DErrorManager {
	
	//errors
	public static final int REMOVE_MODEL_ERROR = 0;
	public static final int INVALID_MATERIAL_VALUE_ERROR = 1;
	public static final int INVALID_MODEL_ROTATION_VALUE_ERROR = 2; 
	public static final int INVALID_GRAPHICAL_SETTING_VALUE_ERROR = 3;
	
	public static void throwError(int i)
	{
		System.err.println("Font3D has encountered the error: " + i);
		System.exit(-1);
	}

}
