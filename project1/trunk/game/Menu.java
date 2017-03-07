package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

// the menu class is a panel that contains the
// new game, reset, and exit buttons
// menu uses gridbaglayout

//this class has methods that specify where the buttons are placed
// and a method that styles the object.

public class Menu extends JPanel {
  /**
* 
*/
  private static final long serialVersionUID = 1L;

  public Menu() {
    this.addMenuButtons();
    this.menuStyle();
  }

  // the addmenubuttons method specifies how the buttons should be
  // placed within the menu object.

  public void addMenuButtons() {
    this.setLayout(new GridBagLayout());
    GridBagConstraints constraint = new GridBagConstraints();
    // setting the positioning for the new game button
    constraint.gridx = 0;
    constraint.gridy = 0;
    constraint.weighty = 1;
    constraint.weightx = 0;
    constraint.fill = GridBagConstraints.BOTH;
    constraint.insets = new Insets(4, 4, 4, 4);
    MenuButton newGameButton = new MenuButton("New Game");
    this.add(newGameButton, constraint);

    // setting the positioning for the new game button
    constraint.gridx = 1;
    MenuButton resetButton = new MenuButton("Reset");
    this.add(resetButton, constraint);

    // setting the positioning for the exit button
    constraint.gridx = 2;
    constraint.weightx = 1;
    MenuButton exitButton = new MenuButton("Quit");
    exitButton.setBackground(Color.RED);
    this.add(exitButton, constraint);

    exitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        System.exit(0);
      }
    });

    // change color of exit button when mouse hovers over
    exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        // System.out.println("mouse entered");
        exitButton.setBackground(new Color(250, 60, 50));
      }

      public void mouseExited(java.awt.event.MouseEvent evt) {
        // System.out.println("mouse exit");
        exitButton.setBackground(new Color(242, 109, 91));
      }
    });

  }

  // the method below is used to change the style of the menu

  public void menuStyle() {

    this.setMinimumSize(new Dimension(250, 50));
    this.setPreferredSize(new Dimension(250, 50));
    this.setBackground(Color.gray);
  }
}
