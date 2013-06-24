import java.awt.event.*; 
import javax.swing.SwingUtilities;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Game extends JFrame{


    public Game() 
    {
	  //Make sure we have nice window decorations
      setDefaultLookAndFeelDecorated(true);
	  
      //add a title
	  setTitle("My New Game");
	  
	  //make it closeable
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
	  //set the initial location
	  setLocationRelativeTo(null);
  
	  //Set up the layout manager.
	  setLayout(new BorderLayout());
	  
	  //makes a new drawPanel and adds it to the JFrame
	  DrawPanel drawPanel = new DrawPanel(600, 600);
	  add(drawPanel, BorderLayout.CENTER);

	  //set the size and make it unresizeable
	  setSize(600, 600);
	  setResizable(false);
	    
      //Display the window.
      pack();
      setVisible(true);
    }

	public static void main(String[] args) {
		new Game();
	}


}
