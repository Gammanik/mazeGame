package game.buttons;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JLabel;

import game.Line;
import game.PlayArea;
import game.Tile;
import game.model.FileManager;

public class ButtonPressed implements ActionListener
  {

    private int click = 0;

    @Override
    public void actionPerformed(ActionEvent e)
      {

        MenuButton currentButton = (MenuButton) e.getSource();
        MenuButton resetButton = (MenuButton) currentButton.getParent().getComponent(1);
        MenuButton quitButton = (MenuButton) currentButton.getParent().getComponent(2);

        if (currentButton.getName().equalsIgnoreCase("Quit"))
          {
            System.exit(0);
          } else if (currentButton.getName().equalsIgnoreCase("File"))
          {
            if (click == 0)
              {
                resetButton.setName("Save");
                resetButton.setText("Save");
                quitButton.setName("Load");
                quitButton.setText("Load");
                quitButton.setBackground(new Color(142, 192, 228));
                click = 1;
              } else if (click == 1)
              {
                resetButton.setName("Reset");
                resetButton.setText("Reset");
                quitButton.setName("Quit");
                quitButton.setText("Quit");
                quitButton.setBackground(new Color(242, 119, 101));
                click = 0;
              }

          } else if (currentButton.getName().equalsIgnoreCase("Reset"))
          {

            Component Parent = currentButton.getParent().getParent();
            Component[] menuAndPlayArea = ((Container) Parent).getComponents();
            Component playArea = menuAndPlayArea[1];

            Component[] sidePanelsAndGrid = ((PlayArea) playArea).getComponents();
            Component[][] originalConfig = ((PlayArea) playArea).getOriginalConfig();

            for (int i = 0; i < sidePanelsAndGrid.length; i++)
              {
                Component[] tiles = ((Container) sidePanelsAndGrid[i]).getComponents();
                for (int j = 0; j < tiles.length; j++)
                  {
                    tiles[j].setBackground(originalConfig[i][j].getBackground());
                    ((JLabel) tiles[j]).setText(((JLabel) originalConfig[i][j]).getText());
                    ((JComponent) tiles[j]).setBorder(((JComponent) originalConfig[i][j]).getBorder());
                    tiles[j].setName(originalConfig[i][j].getName());
                    ((Tile) tiles[j]).setId(((Tile) originalConfig[i][j]).getId());
                    ((Tile) tiles[j]).setAngle(((Tile) originalConfig[i][j]).getAngle());
                    ((Tile) tiles[j]).setCoordinates(((Tile) originalConfig[i][j]).getCoordinates());
                    ((Tile) tiles[j]).setNumberOfLines(((Tile) originalConfig[i][j]).getNumberOfLines());
                    ((Tile) tiles[j]).repaint();
                                        
                  }
              }
          } else if (currentButton.getName().equalsIgnoreCase("Save"))
          {
                        
            int tileId = 0;
            Component Parent = currentButton.getParent().getParent();
            Component[] menuAndPlayArea = ((Container) Parent).getComponents();
            PlayArea playArea = (PlayArea) menuAndPlayArea[1];
             playArea.saveFile();

//            Component[] sidePanelsAndGrid = ((PlayArea) playArea).getComponents();
            Component[][] saveConfig = ((PlayArea) playArea).getSaveConfig();
            

            for (int i = 0; i < saveConfig.length; i++)
              {
//                Component[] tiles = ((Container) sidePanelsAndGrid[i]).getComponents().clone();
                for (int j = 0; j < saveConfig[i].length; j++)
                  {
//                    System.out.println(tileId + " " + saveConfig[i][j]);
                    if(((Tile) saveConfig[i][j]).getCoordinates() == null) 
                      {
                      FileManager.save.add(tileId, new ArrayList<Line>());
                      }
                    else
                      {
                      FileManager.save.add(tileId, ((Tile) saveConfig[i][j]).getCoordinates());
                      FileManager.saveRotation[tileId] = ((Tile) saveConfig[i][j]).getAngle()/90;
                      }
                     //TileID will be represented by the number of times through this loop;
                    //Tile number of lines will be stored as a variable in the Tile class
                    //Tile line coordinates will be stored as an array in the tile class
                      tileId++;
                  }
              }
            FileManager data = new FileManager();
            try
              {
                data.writeFile("testFile.mze");
              } catch (IOException e1)
              {
                // TODO Auto-generated catch block
                e1.printStackTrace();
              }
              
          }

      }

  }
