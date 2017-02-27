package game;

import java.util.Vector;




//This Board Class is set up to store specific "cards or game squares" in an array.
//This Board Class is made up of tiles(16).
//Each Tile has two properties for now. An "isEmpty" property which
//stores a boolean value and a TileID which stores the ID of that specific
//Tile.

// This class can definitely be improved. Right now it acts more as
// a representation of a board rather than an actual object. 


public class Board {
private Vector <BoardTile> boardContainer = new Vector <BoardTile>(16);
public Board(){
for(int i = 0; i<16; i++) {
boardContainer.insertElementAt(new BoardTile(i), i);
}
}
public int getTileIdAt(int index) { return boardContainer.get(index).getTileId(); }
public boolean isTileEmptyAt(int index) { return boardContainer.get(index).getStatus(); }
public int getSize() { return boardContainer.size(); }



}


