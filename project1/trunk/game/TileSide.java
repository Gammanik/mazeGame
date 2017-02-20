package game;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
//import javax.swing.JPanel;

public class TileSide extends JButton{
	
	public TileSide(String num)
	{	
		super(num);
		setBackground(new Color(242,109, 91));
		setOpaque(true);
	}
}
