package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

//the menubutton class is used to create 
//the specific buttons used for the menu.
//once initilized these buttons physically
//shouldn't change.

//only contains one method which is called to change
//the style of the buttons.
public class MenuButton extends JButton {
  /**
*
*/
  private static final long serialVersionUID = 1L;

  public MenuButton(String s) {
    super(s);
    menuButtonStyle();

  }

  public void menuButtonStyle() {
    this.setForeground(Color.WHITE);
    this.setFocusPainted(false);
    this.setBorderPainted(false);
    this.setMinimumSize(new Dimension(90,40));
    this.setPreferredSize(new Dimension(90,40));
    this.setFont(new Font("Tahoma", Font.BOLD, 12));
    this.setBackground(new Color(142, 192, 228));
  }
}
