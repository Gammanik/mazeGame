package game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class Tile extends JLabel {
  /**
* 
*/
  private static final long serialVersionUID = 1L;
  private String id;
  private String name;
  private Color thisColor = Color.ORANGE;

  public Tile(String newID) {
    id = newID;
    setBackground(thisColor);
    setOpaque(true);
    
    this.setText(this.getId());
    // added by blake: basic mouse listener

  }
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    for(int i = 0; i < 16; i++) {
    if(this.getName() == "infoTile" && this.getId().equals("0")) {
      g.drawLine(0, 10, 60, 60); 
      }
    else if(this.getName() == "infoTile" && this.getId().equals("1")) {
      g.drawLine(0, 10, 60, 10); 
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


