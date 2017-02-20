package game;

import java.awt.Color;

import javax.swing.JLabel;
//import javax.swing.JPanel;

public class TileSide extends JLabel{
	
	public TileSide(String num)
	{	
		super(num);
		setBackground(Color.yellow);
		setOpaque(true);
	}
}
