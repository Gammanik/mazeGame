package game;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
//import javax.swing.JPanel;

public class TileSide extends JLabel{
/**
* 
*/
private static final long serialVersionUID = 1L;

public TileSide(String num)
{ 
super(num);
setBackground(Color.WHITE);
setOpaque(true);
//added by blake: basic mouse listener
this.addMouseListener(new MouseListener()
{
 @Override
 public void mouseClicked(MouseEvent arg0) {
   System.out.println("clicked tile");
   setBackground(Color.CYAN);
   
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
}
