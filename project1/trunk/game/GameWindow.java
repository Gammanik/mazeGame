/* @author Kim Buckner
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
 */
package game;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame implements ActionListener
  {
    
    public static final long serialVersionUID=1;

    public GameWindow()
    {
      super("Group C Maze");
     this.setUp();
    }

    
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
    this.setSize(new Dimension(1000, 1000));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(212,223,230));    
        
        
        //this.setResizable(false);
        this.addBoard();
        this.addButtons();
        this.setVisible(true);
        
      return;
        
    }
    

    public void addButtons(){
   
    JPanel panel = new JPanel(new GridBagLayout());
         
         panel.setBackground(new Color(142,192,228) );
         GridBagConstraints c = new GridBagConstraints();
       
         JButton newGameButton = new JButton("New Game");
         newGameButton.setBackground(new Color(142,192,228) );
         newGameButton.setForeground(Color.WHITE);
         newGameButton.setFocusPainted(false);
         newGameButton.setBorderPainted(false);
         newGameButton.setFont(new Font("Tahoma", Font.BOLD, 12));
         c.gridx = 0;
         c.gridy = 0;
         c.weightx = 0;
         c.fill = GridBagConstraints.HORIZONTAL;
         c.insets = new Insets(4,4,4,4);
         c.anchor = GridBagConstraints.WEST;
         panel.add(newGameButton,c); 
         JButton resetButton = new JButton ("Reset"); 
         resetButton.setBackground(new Color(142,192,228) );
         resetButton.setForeground(Color.WHITE);
         resetButton.setFocusPainted(false);
         resetButton.setBorderPainted(false);
         resetButton.setFont(new Font("Tahoma", Font.BOLD, 12));
         c.gridx = 1;
         c.gridy = 0;
         c.weightx = 0;
         c.anchor = GridBagConstraints.WEST;
         panel.add(resetButton,c);
         JButton exitButton = new JButton ("Quit"); 
         exitButton.setBackground(new Color(242,109, 91));
         exitButton.setForeground(Color.WHITE);
         exitButton.setFocusPainted(false);
         exitButton.setFont(new Font("Tahoma", Font.BOLD, 12));
         exitButton.setBorderPainted(false);
         c.gridx = 2;
         c.gridy = 0;
         c.fill = GridBagConstraints.VERTICAL;
         c.insets = new Insets(0,0,0,0);
         c.weightx = 1;
         c.anchor = GridBagConstraints.WEST;
         panel.add(exitButton,c);
         
         /*
         newGameButton.addActionListener(new ActionListener()
         {
        public void actionPerformed(ActionEvent evt) {
            if(evt.getSource() == newGameButton)
               { 
                   dispose();
                   GameWindow game = new GameWindow();
                   game.setVisible(true);
               }
            }
         });
         
        */
         
         
         exitButton.addActionListener(new ActionListener()
         {
          public void actionPerformed(ActionEvent event)
          {
          System.exit(0);
          }
         });
         
         exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseEntered(java.awt.event.MouseEvent evt) {
                 exitButton.setBackground(new Color(250,60, 50));
             }

             public void mouseExited(java.awt.event.MouseEvent evt) {
                 exitButton.setBackground(new Color(242,109, 91));
             }
         });
         
         this.add(panel, BorderLayout.NORTH);

      return;
    }

    public void addBoard(){
    Board gameBoard = new Board();
	JPanel boardPanel = new JPanel();
	boardPanel.setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	c.insets = new Insets(1,1,1,1); 				//sets the space in between tiles
	for(int i = 0; i< 16; i++) {  					//iterates through the board 
		c.gridx = (i+4)%4;                         
		if(gameBoard.isTileEmptyAt(i) == true) {
			JButton b = new JButton("Empty");
			c.gridy = (int) Math.floor(i/4);
			c.anchor = GridBagConstraints.CENTER;
			c.weighty = 1;
			c.weightx = 1;
			c.fill = GridBagConstraints.BOTH;
			b.setBackground(Color.white);
			b.setFocusPainted(false);
			b.setBorderPainted(false);
			boardPanel.add(b,c); 
		}
		else {
			JButton b = new JButton("Taken");
			c.gridy = (int) Math.floor(i/4);
			c.anchor = GridBagConstraints.CENTER;
			c.weighty = 1;
			c.weightx = 1;
			c.fill = GridBagConstraints.BOTH;
			b.setBackground(Color.black);
			b.setFocusPainted(false);
			b.setBorderPainted(false);
			boardPanel.add(b,c); 
		}
	}

	boardPanel.setBorder(new EmptyBorder(300,300,300,300));
    this.add(boardPanel, BorderLayout.CENTER);
    }
    
  };

