package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.border.Border;

public class MenuButton extends JButton 
{
  /**
*
*/
  private static final long serialVersionUID = 1L;

  public MenuButton(String s) 
  {
    super(s);
    setName(s);
    addActionListener(new ButtonPressed());
    addMouseListener(new ButtonHover());
    menuButtonStyle();
    if(s.equalsIgnoreCase("Quit"))
    setBackground(new Color(242, 119, 101));
  }

  public void menuButtonStyle() 
  {
    setForeground(Color.WHITE);
    setFocusPainted(false);
    setBorderPainted(false);
    setMinimumSize(new Dimension(125,60));
    setPreferredSize(new Dimension(125,60));
    setFont(new Font("Tahoma", Font.BOLD, 14));
    setBackground(new Color(142, 192, 228));
  }
}
