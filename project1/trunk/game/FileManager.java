package game;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class FileManager {

  static public ArrayList<ArrayList<Line>> matrix = new ArrayList<ArrayList<Line>>();
  private String fileName;
  private String fileLocation = "./project1/trunk/game/mazeFiles/";
  

FileManager() {
  //TODO:? make it a singleton?
}

  public void readFile(String name) throws IOException {
    //TODO:: clear matrix 
    matrix.clear();
    
    fileName = name;
    ReadFile in = null;
      try {
        in = new ReadFile(fileLocation + fileName);
        in.readInt(); //read 16
        int tileNum = in.readInt();
        while(tileNum != -1) //TODO: will do it for all 32 Tiles
        { 
          ArrayList<Line> linesForTile = new ArrayList<Line>();
        
          int numberOfLines = in.readInt();
          for(int i = 0; i< numberOfLines; i++)
          {
          //read four coordinates
          float[] lineCoordsArray = new float[4];
          for(int coordNum = 0; coordNum < 4; coordNum++) 
          {
//            reduces the float value so 
//            that the coordinates work on a reduced tile size
            lineCoordsArray[coordNum] = (float) (in.readFloat()); 
          }
          Line tempLine = new Line(lineCoordsArray);
          linesForTile.add(tempLine);
          }
        
          /**TODO: matrix.add(rotation, (ArrayList<Line>) linesForTile);
          or make a class TileInfo with setRotation and addLine methods      
          **/
          
          //why do we cast here?))
          matrix.add((ArrayList<Line>) linesForTile);
          tileNum = in.readInt();
        }    
      in.close();
    }
     catch (FileNotFoundException e) 
        {
       System.exit(0);
       e.printStackTrace();
    
      }
    
  }

  public String getFileName() 
  {
    return fileName;
  }

  public void setFileName(String newName)
  {
    fileName = newName;
  }
  public void randomize() 
  {
    Collections.shuffle(matrix, new Random());
  }

}
