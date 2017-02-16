package game;

import java.util.Vector;


//This Board Class is set up to store specific "cards or game squares" in an array.
//This Board Class is made up of tiles(16).
//Each Tile has two properties for now. An "isEmpty" property which
//stores a boolean value and a TileID which stores the ID of that specific
//Tile.


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
	
		