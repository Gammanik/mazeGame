package game;

import java.awt.Color;
import java.awt.Graphics;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Tile extends JLabel {
  /**
  * 
  */
  private static final long serialVersionUID = 1L;
  private String id;
  private String name;
  // possibly store maze line points in an array for each instance.
  // and use below in paintComponent
  private Color thisColor = Color.ORANGE;

  public Tile(String newID) {
    id = newID;
    setBackground(thisColor);
    setOpaque(true);

    this.setText(this.getId());
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

  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (int i = 0; i < Main.matrix.size(); i++) {
      if (this.getName() == "infoTile" && this.getId().equals("0"))
        {
              ArrayList<Line> temp = Main.matrix.get(0);
              for (Line l : temp)
              {
                int temp1 = (int) l.getCoordinates()[0];
                int temp2 = (int) l.getCoordinates()[1];
                int temp3 = (int) l.getCoordinates()[2];
                int temp4 = (int) l.getCoordinates()[3];
                g.drawLine(temp1, temp2, temp3, temp4);
              }
        }
      else if (this.getName() == "infoTile" && this.getId().equals("1"))
      {
            ArrayList<Line> temp = Main.matrix.get(1);
            for (Line l : temp)
            {
              int temp1 = (int) l.getCoordinates()[0];
              int temp2 = (int) l.getCoordinates()[1];
              int temp3 = (int) l.getCoordinates()[2];
              int temp4 = (int) l.getCoordinates()[3];
              g.drawLine(temp1, temp2, temp3, temp4);
            }
      }
      else if (this.getName() == "infoTile" && this.getId().equals("2"))
      {
            ArrayList<Line> temp = Main.matrix.get(2);
            for (Line l : temp)
            {
              int temp1 = (int) l.getCoordinates()[0];
              int temp2 = (int) l.getCoordinates()[1];
              int temp3 = (int) l.getCoordinates()[2];
              int temp4 = (int) l.getCoordinates()[3];
              g.drawLine(temp1, temp2, temp3, temp4);
            }
      }
      else if (this.getName() == "infoTile" && this.getId().equals("3"))
      {
            ArrayList<Line> temp = Main.matrix.get(3);
            for (Line l : temp)
            {
              int temp1 = (int) l.getCoordinates()[0];
              int temp2 = (int) l.getCoordinates()[1];
              int temp3 = (int) l.getCoordinates()[2];
              int temp4 = (int) l.getCoordinates()[3];
              g.drawLine(temp1, temp2, temp3, temp4);
            }
      }
      else if (this.getName() == "infoTile" && this.getId().equals("4"))
      {
            ArrayList<Line> temp = Main.matrix.get(4);
            for (Line l : temp)
            {
              int temp1 = (int) l.getCoordinates()[0];
              int temp2 = (int) l.getCoordinates()[1];
              int temp3 = (int) l.getCoordinates()[2];
              int temp4 = (int) l.getCoordinates()[3];
              g.drawLine(temp1, temp2, temp3, temp4);
            }
      }
      else if (this.getName() == "infoTile" && this.getId().equals("5"))
      {
            ArrayList<Line> temp = Main.matrix.get(5);
            for (Line l : temp)
            {
              int temp1 = (int) l.getCoordinates()[0];
              int temp2 = (int) l.getCoordinates()[1];
              int temp3 = (int) l.getCoordinates()[2];
              int temp4 = (int) l.getCoordinates()[3];
              g.drawLine(temp1, temp2, temp3, temp4);
            }
      }
      else if (this.getName() == "infoTile" && this.getId().equals("6"))
      {
            ArrayList<Line> temp = Main.matrix.get(6);
            for (Line l : temp)
            {
              int temp1 = (int) l.getCoordinates()[0];
              int temp2 = (int) l.getCoordinates()[1];
              int temp3 = (int) l.getCoordinates()[2];
              int temp4 = (int) l.getCoordinates()[3];
              g.drawLine(temp1, temp2, temp3, temp4);
            }
      }
      else if (this.getName() == "infoTile" && this.getId().equals("7"))
      {
            ArrayList<Line> temp = Main.matrix.get(7);
            for (Line l : temp)
            {
              int temp1 = (int) l.getCoordinates()[0];
              int temp2 = (int) l.getCoordinates()[1];
              int temp3 = (int) l.getCoordinates()[2];
              int temp4 = (int) l.getCoordinates()[3];
              g.drawLine(temp1, temp2, temp3, temp4);
            }
      }
      else if (this.getName() == "infoTile" && this.getId().equals("8"))
      {
            ArrayList<Line> temp = Main.matrix.get(8);
            for (Line l : temp)
            {
              int temp1 = (int) l.getCoordinates()[0];
              int temp2 = (int) l.getCoordinates()[1];
              int temp3 = (int) l.getCoordinates()[2];
              int temp4 = (int) l.getCoordinates()[3];
              g.drawLine(temp1, temp2, temp3, temp4);
            }
      }
      else if (this.getName() == "infoTile" && this.getId().equals("9"))
      {
            ArrayList<Line> temp = Main.matrix.get(9);
            for (Line l : temp)
            {
              int temp1 = (int) l.getCoordinates()[0];
              int temp2 = (int) l.getCoordinates()[1];
              int temp3 = (int) l.getCoordinates()[2];
              int temp4 = (int) l.getCoordinates()[3];
              g.drawLine(temp1, temp2, temp3, temp4);
            }
      }
      else if (this.getName() == "infoTile" && this.getId().equals("10"))
      {
            ArrayList<Line> temp = Main.matrix.get(10);
            for (Line l : temp)
            {
              int temp1 = (int) l.getCoordinates()[0];
              int temp2 = (int) l.getCoordinates()[1];
              int temp3 = (int) l.getCoordinates()[2];
              int temp4 = (int) l.getCoordinates()[3];
              g.drawLine(temp1, temp2, temp3, temp4);
            }
      }
      else if (this.getName() == "infoTile" && this.getId().equals("11"))
      {
            ArrayList<Line> temp = Main.matrix.get(11);
            for (Line l : temp)
            {
              int temp1 = (int) l.getCoordinates()[0];
              int temp2 = (int) l.getCoordinates()[1];
              int temp3 = (int) l.getCoordinates()[2];
              int temp4 = (int) l.getCoordinates()[3];
              g.drawLine(temp1, temp2, temp3, temp4);
            }
      }
      else if (this.getName() == "infoTile" && this.getId().equals("12"))
      {
            ArrayList<Line> temp = Main.matrix.get(12);
            for (Line l : temp)
            {
              int temp1 = (int) l.getCoordinates()[0];
              int temp2 = (int) l.getCoordinates()[1];
              int temp3 = (int) l.getCoordinates()[2];
              int temp4 = (int) l.getCoordinates()[3];
              g.drawLine(temp1, temp2, temp3, temp4);
            }
      }
      else if (this.getName() == "infoTile" && this.getId().equals("13"))
      {
            ArrayList<Line> temp = Main.matrix.get(13);
            for (Line l : temp)
            {
              int temp1 = (int) l.getCoordinates()[0];
              int temp2 = (int) l.getCoordinates()[1];
              int temp3 = (int) l.getCoordinates()[2];
              int temp4 = (int) l.getCoordinates()[3];
              g.drawLine(temp1, temp2, temp3, temp4);
            }
      }
      else if (this.getName() == "infoTile" && this.getId().equals("14"))
      {
            ArrayList<Line> temp = Main.matrix.get(14);
            for (Line l : temp)
            {
              int temp1 = (int) l.getCoordinates()[0];
              int temp2 = (int) l.getCoordinates()[1];
              int temp3 = (int) l.getCoordinates()[2];
              int temp4 = (int) l.getCoordinates()[3];
              g.drawLine(temp1, temp2, temp3, temp4);
            }
      }
      else if (this.getName() == "infoTile" && this.getId().equals("15"))
      {
            ArrayList<Line> temp = Main.matrix.get(15);
            for (Line l : temp)
            {
              int temp1 = (int) l.getCoordinates()[0];
              int temp2 = (int) l.getCoordinates()[1];
              int temp3 = (int) l.getCoordinates()[2];
              int temp4 = (int) l.getCoordinates()[3];
              g.drawLine(temp1, temp2, temp3, temp4);
            }
      }
        }
  }

  public String getName() {
    return name;
  }

  public void setName(String newName) {
    name = newName;
  }

  public String getId() {
    return id;
  }

  public void setId(String newId) {
    id = newId;
  }

  public String getAccesibleContext() {
    return id;
  }
}
