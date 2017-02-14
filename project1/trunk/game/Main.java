/**
 * @author Kim Buckner
 * Date: Feb 01, 2017
 *
 *
 * $Author$
 * $Date$
 * $Revision$
 *
 * A starting point for the COSC 3011 programming assignment
 * Probably need to fix a bunch of stuff, but this compiles and runs.
 *
 */
package game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main 
{

  // Probably should declare any buttons here
  //public JButton lbutton,rbutton, mbutton;
  

  public static void main(String[] args)
  {
    // This is the play area
    GameWindow game = new GameWindow("Group X aMaze");
    
    // have to override the default layout to reposition things!!!!!!!

    game.setSize(new Dimension(900, 1000));
    
    // So the debate here was, do I make the GameWindow object the game
    // or do I make main() the game, manipulating a window?
    // Should GameWindow methods know what they store?
    // Answer is, have the "game" do it.
    
    JButton lbutton = new JButton("New Game"); // changed testing to new game - Benjamin
    JButton exitButton = new JButton ("Quit"); // the right button - Benjamin 
    exitButton.addActionListener(new ActionListener()
    {
    	public void actionPerformed(ActionEvent event)
    	{
    		System.exit(0);
    	}
    });
    
    
    
    JButton mbutton = new JButton ("Reset"); // the middle button - Benjamin 
    JPanel panel = new JPanel();
    panel.add(lbutton); //changed this to the new game button-Benjamin 
    panel.add(mbutton); //added the reset button, not functional - Benjamin
    panel.add(exitButton); //added the quit button, not functional - Benjamin
    game.setLayout(new BorderLayout());
    game.add(panel, BorderLayout.NORTH);
    game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    game.getContentPane().setBackground(Color.cyan);
    game.setUp();
    
    
    game.setVisible(true);

    try {
      // The 4 that installed on Linux here
      // May have to test on Windows boxes to see what is there.
      UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
      //This is the "Java" or CrossPlatform version and the default
      //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
      //Linux only
      //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
      // really old style Motif 
      //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
    } 
    catch (UnsupportedLookAndFeelException e) {
     // handle possible exception
    }
    catch (ClassNotFoundException e) {
     // handle possible exception
    }
    catch (InstantiationException e) {
     // handle possible exception
    }
    catch (IllegalAccessException e) {
     // handle possible exception
    }
  
  }
  
};
