package game;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonHover implements MouseListener {

  @Override
  public void mouseClicked(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseEntered(MouseEvent e) 
  {
    if(((MenuButton) e.getSource()).getName() == "Quit")
    {
      ((MenuButton) e.getSource()).setBackground(new Color(240, 0, 0));
    }
    else if(((MenuButton) e.getSource()).getName() == "Reset")
    {
      ((MenuButton) e.getSource()).setBackground(new Color(50, 80, 250));
    }
    else if(((MenuButton) e.getSource()).getName() == "New Game")
    {
      //((GUIButton) e.getSource()).setBackground(new Color(50, 80, 250));
    }
    
  }

  @Override
  public void mouseExited(MouseEvent e) 
  {
    // TODO Auto-generated method stub
    if(((MenuButton) e.getSource()).getName() == "Quit")
    {
      ((MenuButton) e.getSource()).setBackground(new Color(242, 119, 101));
    }
    else if(((MenuButton) e.getSource()).getName() == "Reset")
    {
      ((MenuButton) e.getSource()).setBackground(new Color(142, 192, 228));
    }
    else if(((MenuButton) e.getSource()).getName() == "New Game")
    {
//      ((MenuButton) e.getSource()).setBackground(new Color(142, 192, 228));
    }
  }

}
