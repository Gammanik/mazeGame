package game;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class FileManager {
	
	  static public ArrayList<ArrayList<Line>> matrix = new ArrayList<ArrayList<Line>>();
	  private String fileName;
	  
	
	FileManager(String name) throws IOException
	{
		fileName = name;
		ReadFile in = null;
	    try {
			in = new ReadFile(name);
			 in.readInt(); //read 16
			    int tileNum = in.readInt();
			    while(tileNum != -1) 
			    { 
			      ArrayList<Line> linesForTile = new ArrayList<Line>();
			      
			      int numberOfLines = in.readInt();
			      for(int i = 0; i< numberOfLines; i++)
			      {
			        //read four coordinates
			        float[] lineCoordsArray = new float[4];
			        for(int coordNum = 0; coordNum < 4; coordNum++) 
			        {
			          //reduces the float value so that the coordinates work on a reduced tile size
			          lineCoordsArray[coordNum] = (float) (in.readFloat()); 
			        }
			        Line tempLine = new Line(lineCoordsArray);
			        linesForTile.add(tempLine);
			      }
			      	
			        matrix.add((ArrayList<Line>) linesForTile);
			        tileNum = in.readInt();
			    }			    
			    in.close();
			}
		 catch (FileNotFoundException e) 
	    {
			// TODO Auto-generated catch block
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
