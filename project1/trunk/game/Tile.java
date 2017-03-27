package game;

import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    for (int i = 0; i < 16; i++) {
      if (this.getName() == "infoTile" && this.getId().equals("0"))
        {
            //for (ArrayList<Line> list :matrix)
            
              ArrayList<Line> temp = Main.matrix.get(0);
              for (Line l : temp)
              {
                int temp1 = (int) l.getCoordinates()[0];
                System.out.println((int) l.getCoordinates()[0]);
                int temp2 = (int) l.getCoordinates()[1];
                System.out.println((int) l.getCoordinates()[1]);
                int temp3 = (int) l.getCoordinates()[2];
                System.out.println((int) l.getCoordinates()[2]);
                int temp4 = (int) l.getCoordinates()[3];
                System.out.println((int) l.getCoordinates()[3]);
                g.drawLine(temp1, temp2, temp3, temp4);
              }
              
            
        
        
        }
//        g.drawLine(1, 1, 99, 1);
//        g.drawLine(1, 1, 1, 99);
//        g.drawLine(1, 75, 25, 75);
//        g.drawLine(25, 25, 25, 75);
//        g.drawLine(25, 25, 99, 25);
//        g.drawLine(50, 99, 50, 50);
//        g.drawLine(50, 50, 99, 50);
//        g.drawLine(75, 99, 75, 75);
       else if (this.getName() == "infoTile" && this.getId().equals("1")) {
        //g.drawLine(0, 10, 600, 10);
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
