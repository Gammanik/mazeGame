/**
 /**
 * @author Kim Buckner
 * Date: Feb 01, 2017
 *
 *
 * $Author$
 * $Date$
 * $Revision$
 *
 * A starting point for the COSC 3011 programming assignment
 * Probably need to fix a bunch of stuff, but this compiles and runs.
 *
 */
//the menu class contains the new game, reset and exit buttons.
//this class, once initialized shouldn't have to be modified or changed
//during the game. 

package game;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.*;

//import java.awt.*;
public class Main {
  
  public static int convertToInt(byte[] c) {
    ByteBuffer buffer = ByteBuffer.wrap(c);
    return buffer.getInt();
}
  
  
  
  public static void main(String[] args) throws IOException 
  {
    ReadFile in = null;
    //  FileOutputStream output = null;
   
  
 try
 {   

    in = new ReadFile("default.mze");
    Path path = Paths.get("default.mze");
    byte[] bArray = Files.readAllBytes(path);
    
   
    
//    while(in.readInt() != -1)
//    {
//     
//   }
    in.readInt();
    int temp = in.readInt();
    while(temp != -1) {
      for(int i = 0; i< (temp * 4); i++){
        in.readFloat();
      }
      temp = in.readInt();
    }
        
 }
   finally {
     if(in!=null)
      in.close();
 }
    
    
    
    
 // This is the play area
    new GameWindow();

    try {
      // The 4 that installed on Linux here
      // May have to test on Windows boxes to see what is there.
      UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
      // This is the "Java" or CrossPlatform version and the default
      // UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
      // Linux only
      // UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
      // really old style Motif
      // UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
    } catch (UnsupportedLookAndFeelException e) {
      // handle possible exception
    } catch (ClassNotFoundException e) {
      // handle possible exception
    } catch (InstantiationException e) {
      // handle possible exception
    } catch (IllegalAccessException e) {
      // handle possible exception
    }

  }

};
