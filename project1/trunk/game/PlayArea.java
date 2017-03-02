package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


import javax.swing.JPanel;

// this class is a panel that contains the board and 
// side panels. 
// the position of the board and side panels are dependent
// on the order in which they are called in the constructor
// this could be an area for improvement. 


public class PlayArea extends JPanel {
	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;

	PlayArea(){
		this.setLayout(new GridBagLayout());
		addWestSidePanel();
		addBoard();
		addEastSidePanel();
		playAreaStyle();
	}
	
	private void addWestSidePanel() {
		GridBagConstraints constraint = new GridBagConstraints();
		SidePanel tilePanelWest = new SidePanel();

  	constraint.gridx = 0;
  	constraint.gridy = 0;
	  constraint.insets = new Insets(0,150,0,150);

	  tilePanelWest.setBackground(Color.BLACK);
	  
	  this.add(tilePanelWest, constraint);
		
	}
	
private void addEastSidePanel() {
		GridBagConstraints constraint = new GridBagConstraints();
		SidePanel tilePanelEast = new SidePanel();

  	constraint.gridx = 2;
  	constraint.gridy = 0;
		constraint.insets = new Insets(0,150,0,150);

	  tilePanelEast.setBackground(Color.BLACK);
	  
	  this.add(tilePanelEast, constraint);		
	}
	
// addBoard() constructs the board and adds it to the object.
	public void addBoard() {
		
//		Board gameBoard = new Board();
		JPanel boardPanel = new JPanel();
		boardPanel.setLayout(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.insets = new Insets(1,2,2,1); 
		
		for(int i = 0; i< 16; i++) {    
			constraint.gridx = i%4;                 
			Tile tile = new Tile();
			tile.setName("PlayArea Tile"); //setting the name for checking it in mouseListener
			constraint.gridy = (int) Math.floor(i/4);
			constraint.weighty = 1;
			constraint.weightx = 1;
			constraint.fill = GridBagConstraints.BOTH;
			tile.setBackground(Color.white); // makes tiles white
			boardPanel.add(tile,constraint); 
		}
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;
		boardPanel.setPreferredSize(new Dimension(400,400));
		boardPanel.setMinimumSize(new Dimension(200,200));
		gbc.gridx = 1;
		gbc.gridy = 0;
		boardPanel.setBackground(Color.BLUE);
		this.add(boardPanel, gbc);
		
	}
//	currently not being used but theoretically for styling the 
//	playArea panel.
	
	public void playAreaStyle(){
		//area to set color, size, and things dealing with the style
	}
}
