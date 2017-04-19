package game;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class FileManager {

  static public ArrayList<ArrayList<Line>> matrix = new ArrayList<ArrayList<Line>>(32);
  static public ArrayList<ArrayList<Line>> save = new ArrayList<ArrayList<Line>>(32);
  static public int rotation[] = new int[32];
  static public int saveRotation[] = new int[32];
  private String fileName;
  private String fileLocation = "./trunk/game/mazeFiles/";
  
 
FileManager() {
  //TODO:? make it a singleton?
}

public void readFile(String name) throws IOException {
  matrix.clear();
  int angle;
  fileName = name;
  ReadFile in = null;
  in = new ReadFile(fileLocation + fileName);
  String fileIdentifier = in.readHex(); //reads the hex value 
    try {
      if(fileIdentifier.equals("cafedeed")) 
        {   
          System.out.println("old-save");
        in.readInt(); //read 16
        int tileNum = in.readInt();
        while(tileNum != -1) //TODO: will do it for all 32 Tiles
        { 
          angle = in.readInt();
          ArrayList<Line> linesForTile = new ArrayList<Line>();
          int numberOfLines = in.readInt();
          for(int i = 0; i< numberOfLines; i++)
          {
          //read four coordinates
          float[] lineCoordsArray = new float[4];
          for(int coordNum = 0; coordNum < 4; coordNum++) 
          {
  //          reduces the float value so 
  //          that the coordinates work on a reduced tile size
            lineCoordsArray[coordNum] = (float) (in.readFloat()); 
          }
          Line tempLine = new Line(lineCoordsArray);
          linesForTile.add(tempLine);
          }
        
          /**TODO: matrix.add(rotation, (ArrayList<Line>) linesForTile);
          or make a class TileInfo with setRotation and addLine methods      
          **/
          
          //why do we cast here?
          rotation[tileNum] = angle;
          matrix.add(tileNum,(ArrayList<Line>) linesForTile);
          tileNum = in.readInt();
        }    
      in.close();
        }
      else
        {
          if(fileIdentifier.equals("cafebeef")) 
            {
              
            System.out.println("Randomize");
            in.readInt(); //read 16
            int tileNum = in.readInt();
            while(tileNum != -1) //TODO: will do it for all 32 Tiles
            { 
              
              in.readInt(); //ignoring angle
              ArrayList<Line> linesForTile = new ArrayList<Line>();
              int numberOfLines = in.readInt();
              for(int i = 0; i< numberOfLines; i++)
              {
              //read four coordinates
              float[] lineCoordsArray = new float[4];
              for(int coordNum = 0; coordNum < 4; coordNum++) 
              {
      //          reduces the float value so 
      //          that the coordinates work on a reduced tile size
                lineCoordsArray[coordNum] = (float) (in.readFloat()); 
              }
              Line tempLine = new Line(lineCoordsArray);
              linesForTile.add(tempLine);
              }
            
              /**TODO: matrix.add(rotation, (ArrayList<Line>) linesForTile);
              or make a class TileInfo with setRotation and addLine methods      
              **/
              
              //why do we cast here?))
              Random rand = new Random();
              int n = rand.nextInt(3) + 1;
              int index = 0;
              if(tileNum > 7)
                {
                  index = tileNum + 16;
                }
              System.out.println(matrix.size());
              rotation[index] = n;
              matrix.add((ArrayList<Line>) linesForTile);
              tileNum = in.readInt();
            }    
          in.close();
          randomize();
          for(int i = 0; i < 16; i++)
            matrix.add(8, new ArrayList<Line>());
        }
       }
    }
   catch (FileNotFoundException e) 
      {
     //System.exit(0);
        System.out.println(fileName);
     e.printStackTrace();
  
    }
  
}


public void writeFile(String fileName) throws IOException {
  
  WriteFile out = null;
  out = new WriteFile(fileLocation + fileName);
  out.writeData("cafedeed"); //reads the hex value 
    try 
      {
        out.writeData(16); //read 16
       for(int i  = 0; i < save.size(); i++)
         {
           out.writeData(i); //tileId
           out.writeData(saveRotation[i]); //tile rotation
           out.writeData((save.get(i).size())); //number of lines
           for(int j = 0; j < save.get(i).size(); j++)
             {
             out.writeData(save.get(i).get(j).getCoordinates()[0]);//x1
             out.writeData(save.get(i).get(j).getCoordinates()[1]);//y1
             out.writeData(save.get(i).get(j).getCoordinates()[2]);//x2
             out.writeData(save.get(i).get(j).getCoordinates()[3]);//y2
             }
           
         }
        out.close();
      }
   catch (FileNotFoundException e) 
      {
     //System.exit(0);
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
