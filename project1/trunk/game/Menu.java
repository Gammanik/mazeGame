package game;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JPanel;


// the menu class is a panel that contains the
// new game, reset, and exit buttons
// menu uses gridbaglayout

//this class has methods that specify where the buttons are placed
// and a method that styles the object.

public class Menu extends JPanel 
  {
    private GridBagConstraints constraint = new GridBagConstraints();
	  private static final long serialVersionUID = 1L;
	  
	  public Menu() 
	  {
	  this.setName("menu");
	  this.menuStyle();
	  constraint.weightx = 1;
	  }
	  
    public void addButton(String name)
    {
    	add(new MenuButton(name), constraint);
    }
    public void setInsets(int top, int left, int bottom, int right)
    {
      constraint.insets = new Insets(top,left,bottom,right);
    }
    public void menuStyle() 
    {
      setBackground(Color.gray);
    }
}
