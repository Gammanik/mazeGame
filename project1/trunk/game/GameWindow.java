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
import javax.swing.border.EmptyBorder;


import java.awt.*;  // doesn't this bring in all awt so next 2 lines redundant?
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame implements ActionListener {
    
    public static final long serialVersionUID=1;

    public GameWindow()
    {
      super("Group C Maze"); // names the OS window chrome across the top
     this.setUp();         
    }

    // Written by Dr. Buckner  -- these are not currently working
    public void actionPerformed(ActionEvent e) {
      if("exit".equals(e.getActionCommand()))
        System.exit(0);
      if("reset".equals(e.getActionCommand()))
        System.out.println("reset pressed\n");
      if("new".equals(e.getActionCommand()))
        System.out.println("new pressed\n");
      }


    public void setUp()
    {
//    	this.setSize(new Dimension(900, 900));      // Paul commented out
    	                                            // What is new Dimension() doing? 	
    	this.setSize(1200, 1200);                     // Paul Added              
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);           // centers the window onscreen
        this.getContentPane().setBackground(new Color(212,223,230)); // baby blue
        
        //this.setResizable(false);
        this.addBoard();
        this.addButtons();
        this.addSideTiles(); 
        this.setVisible(true);
        
        System.out.println(this.getHeight());// prints to console height of JFrame
      return;
        
    }
    
//addButtons() adds buttons to the GameWindow object.
//currently there are 3 buttons that were created:
//the new game button, the reset button, and the exit button.
//These buttons are expected to remain the same throughout the
//game and are expect to be placed where they are at during 
//every creation of a new GameWindow object.
    
    public void addButtons() {
    	JPanel panel = new JPanel(new GridBagLayout()); 
         panel.setBackground(new Color(142,192,228) );// sets home menu bar color
         GridBagConstraints constraint = new GridBagConstraints();
       
         JButton newGameButton = new JButton("New Game");
	         newGameButton.setBackground(new Color(142,192,228) );
	         newGameButton.setForeground(Color.WHITE);
	         newGameButton.setFocusPainted(false);
	         newGameButton.setBorderPainted(false);
	         newGameButton.setFont(new Font("Tahoma", Font.BOLD, 12));
	         constraint.gridx = 0;
	         constraint.gridy = 0;
	         constraint.weightx = 0;
	         constraint.fill = GridBagConstraints.HORIZONTAL;
	         constraint.insets = new Insets(4,4,4,4);
	         constraint.anchor = GridBagConstraints.WEST;
	         panel.add(newGameButton,constraint); 
	         
         JButton resetButton = new JButton ("Reset"); 
	         resetButton.setBackground(new Color(142,192,228) );
	         resetButton.setForeground(Color.WHITE);
	         resetButton.setFocusPainted(false);
	         resetButton.setBorderPainted(false);
	         resetButton.setFont(new Font("Tahoma", Font.BOLD, 12));
	         constraint.gridx = 1;
	         constraint.gridy = 0;
	         constraint.weightx = 0;
	         constraint.anchor = GridBagConstraints.WEST;
	         panel.add(resetButton,constraint);
	         
         JButton exitButton = new JButton ("Quit"); 
	         exitButton.setBackground(new Color(242,109, 91));
	         exitButton.setForeground(Color.WHITE);
	         exitButton.setFocusPainted(false);
	         exitButton.setFont(new Font("Tahoma", Font.BOLD, 12));
	         exitButton.setBorderPainted(false);
	         constraint.gridx = 2;
	         constraint.gridy = 0;
	         constraint.fill = GridBagConstraints.VERTICAL;
	         constraint.insets = new Insets(0,0,0,0);
	         constraint.weightx = 1;
	         constraint.anchor = GridBagConstraints.WEST;
	         panel.add(exitButton,constraint);
         
         
         exitButton.addActionListener(new ActionListener()
         {
          public void actionPerformed(ActionEvent event)
          {
          System.exit(0);
          }
         });
                  
         //change color of exit button 
         exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseEntered(java.awt.event.MouseEvent evt) {
            	 System.out.println("mouse entered");
                 exitButton.setBackground(new Color(250,60, 50));
             }

             public void mouseExited(java.awt.event.MouseEvent evt) {
            	 System.out.println("mouse exit");
                 exitButton.setBackground(new Color(242,109, 91));
             }
         });
         
         
         newGameButton.addActionListener(new ActionListener()
         {
          public void actionPerformed(ActionEvent event)
          {
          System.out.println("new game button pressed");
          }
         });
         
         resetButton.addActionListener(new ActionListener()
         {
           public void actionPerformed(ActionEvent event)
           {
            System.out.println("reset button pressed");
           }
         });
         
         this.add(panel, BorderLayout.NORTH);  // places the buttons across the top of the screen
                                               // inside the window chrome
      return;
    }

    
    
    public void addSideTiles() {
	    	
		//init label layout: 8 rows 2 columns distance between columns  
		JPanel tilePanelWest = new JPanel();
		JPanel tilePanelEast = new JPanel();
		
		
		tilePanelWest.setLayout(new GridBagLayout());    
		tilePanelEast.setLayout(new GridBagLayout()); 
		GridBagConstraints constraint = new GridBagConstraints();
		for(int i=0; i<8 ; i++) {
				constraint.gridy = i;
				constraint.weightx = 20;
				constraint.insets = new Insets(20,0,20,0);
				constraint.weighty = 2;
				constraint.fill = GridBagConstraints.BOTH;
				TileSide tile = new TileSide(""+i);
//				tilePanelWest.add(tile);
//				tile.setSize(3000, 3000);
				tilePanelEast.add(tile,constraint);
				TileSide tile2 = new TileSide(""+i);
				tilePanelWest.add(tile2,constraint);
//				tilePanelEast.add(tile);
				

			}
		
		
		
		
		
				//tilesPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	      //tilesPanel.setBorder(new EmptyBorder(300, 300, 300, 3000));
		tilePanelWest.setBorder(new EmptyBorder(30,30,30,30));
		tilePanelEast.setBorder(new EmptyBorder(30,30,30,30));
		tilePanelEast.setPreferredSize(new Dimension(150,150));
		tilePanelWest.setPreferredSize(new Dimension(150,150));
		this.add(tilePanelWest, BorderLayout.WEST);
		this.add(tilePanelEast, BorderLayout.EAST);
				    }
    
    
    
    
//the addBoard method is used to add a clean, empty board to 
//a new GameWindow object. In the future it may be nice to 
//reuse this method in order to update the game board during
//game play.   
    public void addBoard() {
	    Board gameBoard = new Board();
		JPanel boardPanel = new JPanel();
		boardPanel.setLayout(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.insets = new Insets(1,2,2,1); // padding of component and its' edges 				
		for(int i = 0; i< 16; i++) {  					 
			constraint.gridx = (i+4)%4;                         
			if(gameBoard.isTileEmptyAt(i) == true) {
				JButton button = new JButton();
				constraint.gridy = (int) Math.floor(i/4);
				constraint.anchor = GridBagConstraints.CENTER;
				constraint.weighty = 1;
				constraint.weightx = 1;
				constraint.fill = GridBagConstraints.BOTH;
				button.setBackground(Color.white);
				button.setFocusPainted(false);
				button.setBorderPainted(false);
				boardPanel.add(button,constraint); 
			}
			else {
				JButton button = new JButton();
				constraint.gridy = (int) Math.floor(i/4);
				constraint.anchor = GridBagConstraints.CENTER;
				constraint.weighty = 1;
				constraint.weightx = 1;
				constraint.fill = GridBagConstraints.BOTH;
				button.setBackground(Color.black); 					
				button.setFocusPainted(false);
				button.setBorderPainted(false);
				boardPanel.add(button,constraint); 
			}
		}
	
		boardPanel.setBorder(new EmptyBorder(300,200,300,200));
	    this.add(boardPanel, BorderLayout.CENTER);
    }
    
  };

