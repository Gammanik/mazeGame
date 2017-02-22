/*

 * */
package game;
import javax.swing.*; // doesn't this bring in the entire swing library so no need line 20?
import javax.swing.border.EmptyBorder;

import com.sun.glass.ui.Menu;

import java.awt.*;  // doesn't this bring in all awt so next 2 lines redundant?



public class ButtonGrid extends JPanel {

    public static final long serialVersionUID=1;
    
    JFrame frame = new JFrame();
    

    public ButtonGrid() { // constructor
      
        setLayout(new GridLayout(4, 4, 4, 4));
        addButtons();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }



    
    
    private void addButtons() 
    {
        JButton grid = new JButton();
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                grid.setPreferredSize(new Dimension(40, 40));
                add(grid); // adds button to grid

            }
        }
    }

    
}

/*        the UML 
 * 
 *
 *        +---------------------------------------+
 *        |       ButtonGrid                      |
 *        +---------------------------------------+
 *        | + serialVersionUID : static final long|
 *        +---------------------------------------+
 *        |  «cons» ButtonGrid()                  |
 *        |  + setUp() : void                     |
 *        |  + addButtons() : void                |
 *        |  + addSideTiles(): void               | 
 *        +---------------------------------------+
 * 
 * 
 * 
 */



