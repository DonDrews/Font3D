package font.misc;

public class F3DErrorManager {
	
	//errors
	public static final int REMOVE_MODEL_ERROR = 0;
	public static final int INVALID_MATERIAL_VALUE_ERROR = 1;
	public static final int INVALID_MODEL_ROTATION_VALUE_ERROR = 2; 
	public static final int INVALID_GRAPHICAL_SETTING_VALUE_ERROR = 3;
	public static final int INVALID_CAMERA_VALUE_ERROR = 4;
	public static final int REMOVE_CAMERA_ERROR = 5;
	public static final int CANT_FIND_OBJ_ERROR = 6;
	public static final int CANT_READ_FILESYSTEM_ERROR = 7;
	public static final int CANVAS_NO_WORLD_SET_ERROR = 8;
	public static final int INVALID_CANVAS_SIZE_ERROR = 9;
	
	public static void throwError(int i)
	{
		System.err.println("Font3D has encountered the error: " + i);
		System.exit(1);
	}

}
