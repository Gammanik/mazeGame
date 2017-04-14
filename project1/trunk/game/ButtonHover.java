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
    MenuButton currentButton = ((MenuButton) e.getSource());
    // TODO Auto-generated method stub
    if(currentButton.getName().equalsIgnoreCase("Quit"))
    {
      currentButton.setBackground(new Color(242, 119, 101));
    }
    else if(currentButton.getName().equalsIgnoreCase("Reset"))
    {
      currentButton.setBackground(new Color(142, 192, 228));
    }
    else if(currentButton.getName().equalsIgnoreCase("File"))
    {
      currentButton.setBackground(new Color(142, 192, 228));
    }
    else if(currentButton.getName().equalsIgnoreCase("Load"))
    {
      currentButton.setBackground(new Color(142, 192, 228));
    }
    else if(currentButton.getName().equalsIgnoreCase("Save"))
    {
      currentButton.setBackground(new Color(142, 192, 228));
    }
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub
 MenuButton currentButton = ((MenuButton) e.getSource());
    
    if(currentButton.getName().equalsIgnoreCase("Quit"))
    {
      currentButton.setBackground(new Color(240, 0, 0));
    }
    else if(currentButton.getName().equalsIgnoreCase("Reset"))
    {
      currentButton.setBackground(new Color(50, 80, 250));
    }
    else if(currentButton.getName().equalsIgnoreCase("File"))
    {
      currentButton.setBackground(new Color(50, 80, 250));
    }
    else if(currentButton.getName().equalsIgnoreCase("Load"))
    {
      currentButton.setBackground(new Color(50, 80, 250));
    }
    else if(currentButton.getName().equalsIgnoreCase("Save"))
    {
      currentButton.setBackground(new Color(50, 80, 250));
    }
  }

  @Override
  public void mouseEntered(MouseEvent e) 
  {
    MenuButton currentButton = ((MenuButton) e.getSource());
    
    if(currentButton.getName().equalsIgnoreCase("Quit"))
    {
      currentButton.setBackground(new Color(240, 0, 0));
    }
    else if(currentButton.getName().equalsIgnoreCase("Reset"))
    {
      currentButton.setBackground(new Color(50, 80, 250));
    }
    else if(currentButton.getName().equalsIgnoreCase("File"))
    {
      currentButton.setBackground(new Color(50, 80, 250));
    }
    else if(currentButton.getName().equalsIgnoreCase("Load"))
    {
      currentButton.setBackground(new Color(50, 80, 250));
    }
    else if(currentButton.getName().equalsIgnoreCase("Save"))
    {
      currentButton.setBackground(new Color(50, 80, 250));
    }
    
  }

  @Override
  public void mouseExited(MouseEvent e) 
  {
    MenuButton currentButton = ((MenuButton) e.getSource());
    // TODO Auto-generated method stub
    if(currentButton.getName().equalsIgnoreCase("Quit"))
    {
      currentButton.setBackground(new Color(242, 119, 101));
    }
    else if(currentButton.getName().equalsIgnoreCase("Reset"))
    {
      currentButton.setBackground(new Color(142, 192, 228));
    }
    else if(currentButton.getName().equalsIgnoreCase("File"))
    {
      currentButton.setBackground(new Color(142, 192, 228));
    }
    else if(currentButton.getName().equalsIgnoreCase("Load"))
    {
      currentButton.setBackground(new Color(142, 192, 228));
    }
    else if(currentButton.getName().equalsIgnoreCase("Save"))
    {
      currentButton.setBackground(new Color(142, 192, 228));
    }
  }

}
