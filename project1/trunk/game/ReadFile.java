package game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile extends FileInputStream {

  
  public ReadFile(String name) throws FileNotFoundException {
    super(name);
        
  }
  public int readInt() throws IOException {
    byte[] myArray = new byte[4];
    for(int i = 0; i<4; i++) {
      myArray[i] = (byte) read();

    }
    System.out.println(ConvertByte.convertToInt(myArray));
    return ConvertByte.convertToInt(myArray);
    }
    
  public float readFloat() throws IOException{
    byte[] myArray = new byte[4];
    for(int i = 0; i<4; i++) {
      myArray[i] = (byte) read();

    }
    System.out.println(ConvertByte.convertToFloat(myArray));
    return ConvertByte.convertToFloat(myArray);
    }
  
  public ArrayList<ArrayList<Line>> getLines() throws IOException {
    ArrayList<ArrayList<Line>> matrix = new ArrayList<ArrayList<Line>>();
    this.readInt(); //read 16
    
    for(int tileIndex = 0; tileIndex < 15; ) { 
      
      tileIndex = this.readInt(); //current tile number
      ArrayList<Line> linesForTile = new ArrayList<Line>();
      
      int numberOfLines = this.readInt();
      for(int i = 0; i< numberOfLines; i++){
        
        //read four coordinates
        float[] lineCoordsArray = new float[4];
        for(int coordNum = 0; coordNum < 4; coordNum++) {
          lineCoordsArray[coordNum] = this.readFloat();
        }
        Line tempLine = new Line(lineCoordsArray);
        linesForTile.add(tempLine);
      }
        matrix.add(linesForTile);
        linesForTile.clear();
        //TODO: matrix[tileNum] = linesForTile 
    }
    return matrix;
  }
  
  
  
}
