package game;

import java.awt.Color;
import javax.swing.JPanel;


// the menu class is a panel that contains the
// new game, reset, and exit buttons
// menu uses gridbaglayout

//this class has methods that specify where the buttons are placed
// and a method that styles the object.

public class Menu extends JPanel 
  {
	  private static final long serialVersionUID = 1L;
	  
	  public Menu() 
	  {
	  this.setName("menu");
	  this.menuStyle();
	  }
	  
    public void addButton(String name)
    {
    	add(new MenuButton(name));
    }
    public void menuStyle() 
    {
      setBackground(Color.gray);
    }
}
