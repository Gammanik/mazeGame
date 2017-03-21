package game;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class ResetComponentAction implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent e) {
    Component source = (Component) e.getSource();
    Component Parent = source.getParent().getParent();
    Component[] menuAndPlayArea = ((Container) Parent).getComponents();
    Component playArea = menuAndPlayArea[1];
    
    Component[] sidePanelsAndGrid = ((PlayArea) playArea).getComponents();
    Component[][] originalConfig = ((PlayArea) playArea).getOriginalConfig();
    
    for(int i = 0; i < sidePanelsAndGrid.length; i++) {
      Component[] tiles = ((Container) sidePanelsAndGrid[i]).getComponents();
      for(int j= 0; j < tiles.length; j++) {
          tiles[j].setBackground(originalConfig[i][j].getBackground());
          ((JLabel) tiles[j]).setText(((JLabel) originalConfig[i][j]).getText());
          ((JComponent) tiles[j]).setBorder(((JComponent) originalConfig[i][j]).getBorder());
          tiles[j].setName(originalConfig[i][j].getName());
          ((Tile) tiles[j]).setId(((Tile) originalConfig[i][j]).getId());
      }
   }
  }

}
