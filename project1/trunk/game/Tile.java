package game;

import java.awt.Color;
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
    // added by blake: basic mouse listener

  }

  // public void addListener() {
  // this.addMouseListener(new MouseListener()
  // {
  // @Override
  // public void mouseClicked(MouseEvent arg0) {
  // System.out.println("clicked tile");
  // doClicked();
  // setBackground(Color.CYAN);
  // //send info method
  //
  // }
  //
  // @Override
  // public void mouseEntered(MouseEvent arg0) { }
  // @Override
  // public void mouseExited(MouseEvent arg0) { }
  // @Override
  // public void mousePressed(MouseEvent arg0) { }
  // @Override
  // public void mouseReleased(MouseEvent arg0) { }
  // });
  // }

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

// public void doClicked()
// {
// clicked = true;
// }
//
// public void clearClicked()
// {
// clicked = false;
// }

