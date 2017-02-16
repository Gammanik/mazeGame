package game;


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