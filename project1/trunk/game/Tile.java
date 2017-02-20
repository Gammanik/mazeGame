package game;

//The tile class stores two values for now. 
//It stores the status of a tile (whether empty or not) and
//the tiles unique ID (which can be used to identify different tiles).

public class Tile {
		private boolean isEmpty;
		private int tileId;
		
		public Tile(int Id) {
			isEmpty = true;
			tileId = Id;
			}
		public int getTileId() { return tileId; }
		public boolean getStatus() { return isEmpty; }
	}

/*
 *         
 * 
 * 
 * 
 * 
 */