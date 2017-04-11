package game;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
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

  private Component[][] startingConfig;   
  
  
  private static final long serialVersionUID = 1L;

  PlayArea() {
    setLayout(new GridBagLayout());
    addWestSidePanel();
    addBoard();
    addEastSidePanel();
    playAreaStyle();
    this.setName("playArea");
    
  }

  private void addWestSidePanel() {
    GridBagConstraints constraint = new GridBagConstraints();
    SidePanel tilePanelWest = new SidePanel(0);

    constraint.gridx = 0;
    constraint.gridy = 0;
    constraint.insets = new Insets(0, 150, 0, 150);
    
    tilePanelWest.setName("tilePanelWest");
    tilePanelWest.setBackground(Color.gray);

    this.add(tilePanelWest, constraint);

  }

  private void addEastSidePanel() {
    GridBagConstraints constraint = new GridBagConstraints();
    SidePanel tilePanelEast = new SidePanel(8);

    constraint.gridx = 2;
    constraint.gridy = 0;
    constraint.insets = new Insets(0, 150, 0, 150);
    
    tilePanelEast.setName("tilePanelEast");
    tilePanelEast.setBackground(Color.gray);

    this.add(tilePanelEast, constraint);
  }

  // addBoard() constructs the board and adds it to the object.
  public void addBoard() {

   Board boardPanel = new Board();
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.gridx = 1;
    gbc.gridy = 0;
    boardPanel.setBackground(Color.blue);
    this.add(boardPanel, gbc);

  }

  public final void saveConfig() {
    Component[][] temp = new Component[3][];
    temp[0] = new Component [8];
    temp[1] = new Component [16];
    temp[2] = new Component [8];
    for(int i = 0; i < getComponents().length; i++) {
      Component[] tiles = ((Container) getComponents()[i]).getComponents();
      for(int j= 0; j < tiles.length; j++) {
        Tile originalTile = new Tile((Tile) tiles[j]);
         temp[i][j] = originalTile;
      }
   }
    startingConfig = temp.clone();   
  }

   
  public Component[][] getOriginalConfig() {
    return startingConfig;
  }
  
  // currently not being used but theoretically for styling the
  // playArea panel.
  public void playAreaStyle() {
    // area to set color, size, and things dealing with the style
  }
}
