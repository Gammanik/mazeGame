/*
 * from http://stackoverflow.com/questions/36380516/drawing-a-grid-in-a-jframe
 * */
package game;
import javax.swing.*; // doesn't this bring in the entire swing library so no need line 20?
import javax.swing.border.EmptyBorder;

import com.sun.glass.ui.Menu;

import java.awt.*;  // doesn't this bring in all awt so next 2 lines redundant?


public class ButtonGrid extends JPanel {

    public static final long serialVersionUID=1;
    
    JFrame frame = new JFrame();
    int t = 4;// sets the dimensions of the button grid

    public ButtonGrid() { // constructor
        frame.setContentPane(this);
        setLayout(new GridLayout(t, t, 3, 3));
        addButtons(t);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }



    private void addButtons(int t) {
        JButton grid;
        for (int y = 0; y < t; y++) {
            for (int x = 0; x < t; x++) {
                grid = new JButton(x + "," + y); // creates new button
                grid.setPreferredSize(new Dimension(55, 55));
                add(grid); // adds button to grid

            }
        }
    }

    
}