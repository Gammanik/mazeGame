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
  
  static ArrayList<ArrayList<Line>> matrix = new ArrayList<ArrayList<Line>>();
  public static int convertToInt(byte[] c) {
    ByteBuffer buffer = ByteBuffer.wrap(c);
    return buffer.getInt();
}
  
  public static void main(String[] args) throws IOException 
  {
    ReadFile in = null;
    in = new ReadFile("default.mze");
    
    int numTiles = in.readInt(); //read 16
    System.out.println(numTiles);
    int tileNum = in.readInt();
    while(tileNum != -1) 
    { 
      
     // int tileIndex = this.readInt(); //current tile number
      //System.out.println(tileIndex);
      ArrayList<Line> linesForTile = new ArrayList<Line>();
      
      int numberOfLines = in.readInt();
      for(int i = 0; i< numberOfLines; i++){
        
        //read four coordinates
        float[] lineCoordsArray = new float[4];
        for(int coordNum = 0; coordNum < 4; coordNum++) 
        {
          lineCoordsArray[coordNum] = in.readFloat();
        }
        Line tempLine = new Line(lineCoordsArray);
        linesForTile.add(tempLine);
      }
       // System.out.println(tileNum + " - numLines: " + linesForTile.size() + " - last Float: "+ (int) linesForTile.get(linesForTile.size()-1).getCoordinates()[0]);
        matrix.add((ArrayList<Line>) linesForTile.clone());
        linesForTile.clear();
        tileNum = in.readInt();
    }
    
    in.close();
   // System.out.println(matrix);
   
    
    
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
