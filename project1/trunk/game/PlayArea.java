package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

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

  PlayArea() {
    this.setLayout(new GridBagLayout());
    addWestSidePanel();
    addBoard();
    addEastSidePanel();
    playAreaStyle();
  }

  private void addWestSidePanel() {
    GridBagConstraints constraint = new GridBagConstraints();
    SidePanel tilePanelWest = new SidePanel(0);

    constraint.gridx = 0;
    constraint.gridy = 0;
    constraint.insets = new Insets(0, 150, 0, 150);

    tilePanelWest.setBackground(Color.gray);

    this.add(tilePanelWest, constraint);

  }

  private void addEastSidePanel() {
    GridBagConstraints constraint = new GridBagConstraints();
    SidePanel tilePanelEast = new SidePanel(8);

    constraint.gridx = 2;
    constraint.gridy = 0;
    constraint.insets = new Insets(0, 150, 0, 150);

    tilePanelEast.setBackground(Color.gray);

    this.add(tilePanelEast, constraint);
  }

  // addBoard() constructs the board and adds it to the object.
  public void addBoard() {

    // Board gameBoard = new Board();
    JPanel boardPanel = new JPanel();
    boardPanel.setLayout(new GridBagLayout());
    GridBagConstraints constraint = new GridBagConstraints();
    // constraint.insets = new Insets(1,1,1,1);

    for (int i = 0; i < 16; i++) {
      constraint.gridx = i % 4;
      Tile tile = new Tile(" ");
      tile.setName("emptyTile"); // setting the name for checking it in
                                 // mouseListener
      Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
      tile.setBorder(border);
      constraint.gridy = (int) Math.floor(i / 4);
      constraint.weighty = 1;
      constraint.weightx = 1;
      constraint.fill = GridBagConstraints.NONE;
      tile.setBackground(Color.white); // makes tiles white
      tile.setMinimumSize(new Dimension(100, 100));
      tile.setPreferredSize(new Dimension(100, 100));
      boardPanel.add(tile, constraint);
    }
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.gridx = 1;
    gbc.gridy = 0;
    boardPanel.setBackground(Color.blue);
    this.add(boardPanel, gbc);

  }

  // currently not being used but theoretically for styling the
  // playArea panel.

  public void playAreaStyle() {
    // area to set color, size, and things dealing with the style
  }
}
