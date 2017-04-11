package game;
//Methods obained from the URL Doctor Buckner provided

import java.nio.ByteBuffer;

public class ConvertByte {


public static int convertToInt(byte[] array) 
{
    ByteBuffer buffer = ByteBuffer.wrap(array);
    return buffer.getInt();
}

public static float convertToFloat(byte[] array) 
{
    ByteBuffer buffer = ByteBuffer.wrap(array);
    return buffer.getFloat();
}
  
}
