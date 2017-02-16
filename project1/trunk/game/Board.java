package game;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JPanel;

public class Board {
	
	
	private Vector <Tile> boardContainer = new Vector <Tile>(16);
	
	public Board(){
		for(int i = 0; i<16; i++) {
			boardContainer.insertElementAt(new Tile(i), i);
		}
	}
	public int getTileIdAt(int index) { return boardContainer.get(index).getTileId(); }
	public boolean isTileEmptyAt(int index) { return boardContainer.get(index).getStatus(); }
	public int getSize() { return boardContainer.size(); }
}
	
		