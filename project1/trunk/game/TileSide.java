package game;

import java.awt.Color;

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
}
}
