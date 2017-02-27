package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

// this class created the side panels

public class SidePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SidePanel(){
		addTiles();
	}
	
	public void addTiles(){
		this.setLayout(new GridBagLayout());    
		GridBagConstraints cons = new GridBagConstraints();
		
		for(int i=0; i<8 ; i++) {
			cons.gridy = i;
			cons.weightx = 1;
			cons.insets = new Insets(5,5,5,5);
			cons.weighty = 0;
			TileSide tile = new TileSide("");
			tile.setMinimumSize(new Dimension(50,50));
			tile.setPreferredSize(new Dimension(100,100));
			this.add(tile,cons);
		}
	  
	}
	
}
