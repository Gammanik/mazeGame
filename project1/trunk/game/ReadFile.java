package game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ReadFile extends FileInputStream {

  
  public ReadFile(String name) throws FileNotFoundException 
  {
    super(name);   
  }
  public int readInt() throws IOException 
  {
    byte[] myArray = new byte[4];
    for(int i = 0; i<4; i++) 
    {
      myArray[i] = (byte) read();
    }
   
    return ConvertByte.convertToInt(myArray);
  }
    
  public float readFloat() throws IOException 
  {
    byte[] myArray = new byte[4];
    for(int i = 0; i<4; i++) 
    {
      myArray[i] = (byte) read();
    }
    
    return ConvertByte.convertToFloat(myArray);
  }
  
 
  
  
  
}
