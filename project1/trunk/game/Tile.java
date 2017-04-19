package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Tile extends JLabel {

	private int angle;
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private int numberOfLines;
	private ArrayList<Line> coordinates;
	private boolean infoTile;

	private Color thisColor = Color.ORANGE;

	public Tile(String newID) {
		id = newID;
//		setBackground(thisColor);
		setOpaque(true);
		setMinimumSize(new Dimension(101, 101));
		setPreferredSize(new Dimension(101, 101));
		for(int i = 0; i < FileManager.rotation.length; i++) 
		  {
		  if(getId().equals(""+i)) 
		    {
		     setAngle(FileManager.rotation[i] * 90);
		    }
		}
		for(int i = 0; i < FileManager.matrix.size(); i++)
		  {
		    if(getId().equals(""+i)) 
		      {
  		    if(FileManager.matrix.get(i).size() == 0)
  		      {
  		        setBackground(Color.WHITE);
  		        setName("emptyTile");
  		        setAngle(0);
  		        setBorder(BorderFactory.createLineBorder(Color.gray, 1));
  		      }
  		    else
  		      {
  		        setBackground(Color.ORANGE);
  		        setName("infoTile");
  		        setBorder(BorderFactory.createLineBorder(Color.gray, 0));
  		      }
		      }
		  }
		
		
	}

	// copy constructor
	public Tile(Tile originalCopy) {
		this.setBackground(originalCopy.getBackground());
		this.setText(originalCopy.getText());
		this.setBorder(originalCopy.getBorder());
		this.setName(originalCopy.getName());
		this.setPreferredSize(originalCopy.getPreferredSize());
		this.setMinimumSize(originalCopy.getMinimumSize());
		this.setLocation(originalCopy.getLocation());
		this.setHorizontalAlignment(originalCopy.getHorizontalAlignment());
		this.setId(originalCopy.getId());
		this.setSize(originalCopy.getSize());
		this.setFont(originalCopy.getFont());
		this.setAngle(originalCopy.getAngle());
		this.setCoordinates(originalCopy.getCoordinates());
		this.setNumberOfLines(originalCopy.getNumberOfLines());

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		g2.rotate(angle * Math.PI / 180, this.getBounds().width / 2, this.getBounds().height / 2);

		for (int i = 0; i < FileManager.matrix.size(); i++) {
		  int lineCounter = 0;
			if ( this.getId().equals("" + i)) {
				ArrayList<Line> temp = FileManager.matrix.get(i);
				setCoordinates(temp);
				for (Line l : temp) {
					int temp1 = (int) l.getCoordinates()[0];
					int temp2 = (int) l.getCoordinates()[1];
					int temp3 = (int) l.getCoordinates()[2];
					int temp4 = (int) l.getCoordinates()[3];
					g2.drawLine(temp1, temp2, temp3, temp4);
					lineCounter++;
				}
				setNumberOfLines(lineCounter);
			}
			
		}
	}

	public String getName() 
	  {
		return name;
	  }

	public void setName(String newName) 
	  {
		name = newName;
	  }
	
	public String getId() 
	  {
		return id;
	  }

	public void setId(String newId) 
	  {
		id = newId;
	  }

	public String getAccesibleContext() 
	  {
		return id;
	  }

	public int getAngle() 
	  {
		return angle;

	  }

	public void changeAngle() 
	  {
		angle += 90;
	  }

	public void setAngle(int ang) 
	  {
		angle = ang;
	  }
	public void setNumberOfLines(int number)
	{
	  numberOfLines = number;
	}
	public int getNumberOfLines()
	{
	  return numberOfLines;
	}
	public void setCoordinates(ArrayList<Line> lines)
	{
	  coordinates = lines;
	}
	public ArrayList<Line> getCoordinates()
	  {
	    return coordinates;
	  }
	public boolean hasInfo()
	{
	  return infoTile;
	}
	public void setAsInfoTile(boolean condition)
	{
	  infoTile = condition;
	}

}
