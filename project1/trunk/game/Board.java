package game;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Board extends JPanel{

  private static final long serialVersionUID = 1L;

  public Board() {
   setLayout(new GridBagLayout());
   addTiles();
   setStyle();
  }
  
  public void addTiles(){
    
    GridBagConstraints constraint = new GridBagConstraints();

    for (int i = 0; i < 16; i++) {
      constraint.gridx = i % 4;
      Tile tile = new Tile(" ");
      tile.setName("emptyTile"); 
      Border border = BorderFactory.createLineBorder(Color.gray, 1);
      tile.setBorder(border);
      constraint.gridy = (int) Math.floor(i / 4);
      constraint.weighty = 1;
      constraint.weightx = 1;
      constraint.fill = GridBagConstraints.NONE;
      tile.setBackground(Color.WHITE); 
      tile.setAngle(0);
      add(tile, constraint);
    }
  }
  public void setStyle() {
    setBackground(Color.BLACK);
  }
}