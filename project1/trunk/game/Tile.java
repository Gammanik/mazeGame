package game;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class Tile extends JLabel{
/**
* 
*/
private static final long serialVersionUID = 1L;

private boolean clicked = false;

private Color thisColor = Color.BLUE;

public Tile()
{ 
setBackground(thisColor);
setOpaque(true);
//added by blake: basic mouse listener
this.addMouseListener(new MouseListener()
{
 @Override
 public void mouseClicked(MouseEvent arg0) {
   System.out.println("clicked tile");
   doClicked();
   setBackground(Color.CYAN);
   //send info method
   
 }

 @Override
 public void mouseEntered(MouseEvent arg0) {
   // TODO Auto-generated method stub
   
 }

 @Override
 public void mouseExited(MouseEvent arg0) {
   // TODO Auto-generated method stub
   
 }

 @Override
 public void mousePressed(MouseEvent arg0) {
   // TODO Auto-generated method stub
   
 }

 @Override
 public void mouseReleased(MouseEvent arg0) {
   // TODO Auto-generated method stub
   
 }
});
}

public void doClicked()
{
  clicked = true;
}

public void clearClicked()
{
  clicked = false;
}
}
