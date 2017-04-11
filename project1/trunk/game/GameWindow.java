/* @author Ben, Jake, Nikita, Dylan, Paul
 * Date: Feb 01, 2017
 *
 * $Author$
 * $Date$
 * $Revision$
 *
 * This is the actual "game". May/will have to make some major changes.
 * This is just a "hollow" shell.
 *
 * When you get done, I should see the buttons at the top in the "play" area
 * (not a pull-down menu). The only one that should do anything is Quit.
 *
 * Should also see something that shows where the 4x4 board and the "spare"
 * tiles will be when we get them stuffed in.
 * REMEMBER Dr. Buckner doesn't want the lines longer than 80 characters long.
 */
package game;
import javax.swing.*; // doesn't this bring in the entire swing library so no need line 20?
import javax.swing.border.Border;

import java.awt.*;  // doesn't this bring in all awt so next 2 lines redundant?
import java.awt.event.*;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;

public class GameWindow extends JFrame{
    
    public static final long serialVersionUID=1;
    //saving previous clicked component
    private static Tile previous = new Tile(" ");
    private static boolean infoTileClicked = false;

   private JPanel frame = new JPanel(new GridBagLayout());
 
    
    public GameWindow() {
      
     super("Group C Maze"); // names the OS window chrome across the top
     this.addComponents();
     frame.setName("frame");
     this.setUpWindow();   
     this.addTilesListeners(this);
     
     
     
    }
    
    public void setUpWindow()
    {
    try {
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
         } catch (Exception e) {
                    e.printStackTrace();
         }
    
    this.setSize(1000, 1050);                    
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);           
    this.getContentPane().setBackground(new Color(212,223,230)); //baby blue
    this.add(frame);
    this.setVisible(true);
    frame.setBackground(Color.gray);
    //System.out.println(this.getHeight());// prints to console height of JFrame     
    }
    
//    this is where the different components of the game window are
//    called
    public void addComponents(){ 
      this.addMenu();
      this.addPlayArea(); 
    }
    
// the addMenu and addPlayArea methods (below) are used to specify
//    where in the gameWindow they belong
// The "frame" panel is using gridbaglayout
    
    public void addMenu() {
//      the menu object is a panel that includes the new game, reset,
//      and exit buttons
         Menu menu = new Menu();
         GridBagConstraints gbc = new GridBagConstraints();
         gbc.weightx = 1;
         gbc.weighty = 1;
         gbc.gridx = 0;
         gbc.gridy = 0;
         gbc.anchor = GridBagConstraints.NORTHWEST;
         gbc.insets = new Insets(0,10,0,0);
         frame.add(menu, gbc);  
      return;
    }

        
    public void addPlayArea() {
//      the playArea is a panel that includes the 4X4 board and the side
//      panels
    PlayArea playArea = new PlayArea();
    GridBagConstraints playAreaPosition = new GridBagConstraints();
    playAreaPosition.gridx = 0;
    playAreaPosition.gridy = 0;
    playArea.setBackground(Color.gray);
    playArea.setName("playArea");
    playArea.saveConfig();
    frame.add(playArea, playAreaPosition);

    }
     
    public void addTilesListeners(Container comp) {
            
      final Component[] components = comp.getComponents(); 
      
  
      for (Component component : components)
      {
      
          if (component instanceof Container)
          {
              Component[] child = ((Container)component).getComponents();
              
              if (child != null && child.length > 0)
              {
                
                  addTilesListeners((Container)component);
                  
              }
          }
          
          component.addMouseListener(new MouseAdapter()
          {
            public void mousePressed(MouseEvent evt)
              {
            //   if(SwingUtilities.isLeftMouseButton(evt))      
              // {
                int clicks = evt.getClickCount();
                  if(SwingUtilities.isLeftMouseButton(evt))  
                    {
                    if(component.getName() == "infoTile" && clicks == 1 && !infoTileClicked) 
                    {
                      component.setBackground(Color.YELLOW);
                  
                 // component.getAccessibleContext();
                  infoTileClicked = true;
                  //changing color of previous component
                  //in case click on sideTiles again (want to choose another)
                 
                  previous = (Tile) component; //remember previous clicked tile
                  
                      } 
                    else
                    { //when clicked out of SIDE tiles
                  if(previous.getName() != "emptyTile")
                     previous.setBackground(Color.ORANGE);
                  //System.out.println("else case: " + previous.getName());
                  
                  // click to a empty tile after an info tile
                  if(infoTileClicked && component.getName() == "emptyTile")
                  { 
                    ////System.out.println(component.getAccessibleContext().getAccessibleText());
                    component.setBackground(Color.ORANGE);
                    ((Tile) component).setId(previous.getId());
                    ((Tile) component).setText(previous.getText()); // -edit  by Dylan 
                    ((Tile) component).setFont(new Font("Tahoma", Font.BOLD, 20));
                    Border border = BorderFactory.createLineBorder(Color.BLACK, 0);
                    ((Tile) component).setBorder(border);
                    //the above code sets the text from the previously clicked tile
                    //into the currently clicked tile
                    ((Tile) component).setHorizontalAlignment(SwingConstants.CENTER); // -edit by Dylan
                    //the above code centers the numbers in the tiles
                    previous.setText(" "); // -edit by Dylan 
                    border = BorderFactory.createLineBorder(Color.BLACK, 1);
                    previous.setBorder(border);
                    previous.setBackground(Color.WHITE); //make for the color cannot be changed
                    previous.setName("emptyTile"); //marked as used
                    previous.setId("");
                    component.setName("infoTile");
                    repaint();
                  }
                  infoTileClicked = false;
                } 
            //  }
            }
                 if(SwingUtilities.isRightMouseButton(evt) && (component.getName() == "infoTile"))
                {
                   ((Tile) component).changeAngle();
                 repaint();
               
                }
                  
              }
             
          });
      }
    }    
  };


