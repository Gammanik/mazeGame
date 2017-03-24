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
import java.io.IOException;
import java.nio.ByteBuffer;
import javax.swing.*;
import java.util.ArrayList;

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
   
    class Line{

      private float[] coordinates = new float[4];
      
     public Line(float[] coordinates) {
           this.coordinates = coordinates;
      }
    
    }
    
    ArrayList<ArrayList<Line>> matrix = new ArrayList<ArrayList<Line>>();
  
 try
 {   

    in = new ReadFile("default.mze");    
   
   
    in.readInt(); //read 16
    
    //while(in.readInt() != -1) { //tile number
    for(int tileNum = 0; tileNum < 15; ) { 
      
      tileNum = in.readInt(); //current tile number
      
      int numberOfLines = in.readInt();
      for(int i = 0; i< (numberOfLines * 4); i++){
        
        //for
        in.readFloat();
      }
      
      //TODO: add tile with lines here
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
