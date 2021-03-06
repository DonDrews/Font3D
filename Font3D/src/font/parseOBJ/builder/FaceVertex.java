package font.parseOBJ.builder;

// Written by Sean R. Owens, sean at guild dot net, released to the
// public domain. Share and enjoy. Since some people argue that it is
// impossible to release software to the public domain, you are also free
// to use this code under any version of the GPL, LPGL, Apache, or BSD
// licenses, or contact me for use of another license.

import java.util.*;
import java.text.*;
import java.io.*;

import font.vectors.F3DTexVector;
import font.vectors.F3DVector3;

public class FaceVertex {

    int index = -1;
    public F3DVector3 v = null;
    public F3DTexVector t = null;
    public F3DVector3 n = null;

    public String toString() {
        return v + "|" + n + "|" + t;
    }
}