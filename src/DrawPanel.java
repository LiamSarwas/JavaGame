import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Timer;
import javax.swing.JPanel;


class DrawPanel extends JPanel implements ActionListener, KeyListener, MouseListener

{
	private int width;
	private int height;
	private int numXCells = 20;
	private int numYCells = 20;
	private Map myMap;
	private Color color;
	private Character me;
    BufferedImage img = null;
    Timer timer;
    
	
	public DrawPanel(int x,  int y)
	{
		//sets all of the size options for the panel
		Dimension size = new Dimension(x, y);
		width = size.width;
		height = size.height;
	    setPreferredSize(size);
	    setMinimumSize(size);	
	    
	    //sets a background color of the panel
	    color = new Color(100, 225, 250);
	    setBackground(color);
	
	    //makes the panel the focus for events and adds a keylistener to hear keyevents
	    setFocusable(true);
	    addKeyListener(this);
	    
	    
	    //imports a sheet of sprites
	    try 
	    {
	        img = ImageIO.read(new File("/Users/Liam/Desktop/sprites.png"));
	    } 
	    catch (IOException e)
	    {
	    }

	    //creates an instant of the character and map classes
	    myMap = new Map(numXCells, numYCells);
	    me = new Character(Color.BLACK, 0, 0, myMap);
	    
	    //creates and starts the timer
	    timer = new Timer(100, this);
        timer.start();   
	}
	
    private void draw(Graphics g)
    {
    	//creates a new graphics2d object by casting the graphics object
        Graphics2D g2d = (Graphics2D) g;
        
        //sets a color for the graphics object
        g2d.setColor(color);
        
        //draws 
        for(int i = 0; i < numXCells; i++)
        {
        	for(int j = 0; j < numYCells; j++)
        	{	
        		//grabs a subimage from the sprite sheet FIX THIS TO RESIZE FROM SOURCE TO DESTINATION
        		 g2d.drawImage(img.getSubimage(myMap.getValue(i, j).getType()*33, 0, 32, 32), i*(width/numXCells), j*(height/numYCells), null);	
        	}
        }
         
        //sets the color to the color of the character
    	g2d.setColor(me.getColor());
    	
    	//block based motion
    	g2d.fillRect(me.getLocX()*width/numXCells, me.getLocY()*height/numYCells, 30, 60);
    	
    	//non block-based motion
    	//g2d.fillRect(me.getLocX(), me.getLocY(), 50, 100);
    }

    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        //this method is called whenever a repaint is called, and it calls the draw method
        draw(g);
    }
    
	public void actionPerformed(ActionEvent e)
	{
		//this method is called every time the timer ticks
		me.move();
		repaint();
	}

	public void keyPressed(KeyEvent e) 
	{
		//sends a key event to the character
		me.keyPressed(e);
	}

	public void keyReleased(KeyEvent e)
	{
		//sends a key event to the character
		me.keyReleased(e);
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		//empty stub
	}

	@Override
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
