package game;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
//import javax.swing.JPanel;

public class TileSide extends JButton{
  
  public TileSide(String num)
  {  
    super(num); // calls the default JButton 1 parameter method and puts
                // passed in text (e.g. num on that button)
    setBackground(new Color(242,109, 91));
    setOpaque(true);
  }
}


/*        the UML 
 * 
 *
 *        +-------------------------------+
 *        |     TileSide                  |
 *        +-------------------------------+
 *        |  «cons» TileSide(String text) |
 *        |  setBackground()              |
 *        |  setOpaque()                  |
 *        +-------------------------------+
 * 
 * 
 * 
 */