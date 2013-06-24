import java.awt.Color;
import java.awt.event.KeyEvent;


public class Character {

	private int locX;
	private int locY;
	private Color color;
	private int dx;
	private int dy;
	private Map charMap;
	private int damage = 40;
	
	public Character(Color newColor, int x, int y, Map map)
	{
		color = newColor;
		locX = x;
		locY = y;
		charMap = map;
	}
	
	public int getLocX()
	{
		return locX;
	}
	
	public int getLocY()
	{
		return locY;
	}
	
	public int getDX()
	{
		return dx;
	}
	
	public int getDY()
	{
		return dy;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }
	
	public void keyReleased(KeyEvent e) {
	        int key = e.getKeyCode();
	
	        if (key == KeyEvent.VK_LEFT) {
	            dx = 0;
	        }
	
	        if (key == KeyEvent.VK_RIGHT) {
	            dx = 0;
	        }
	
	        if (key == KeyEvent.VK_UP) {
	            dy = 0;
	        }
	
	        if (key == KeyEvent.VK_DOWN) {
	            dy = 0;
	        }
	    }

	public void move()
	{
		if(charMap.isValid(locX + dx, locY + dy) && charMap.isValid(locX + dx, locY + dy + 1))
		{
			locX += dx;
			locY += dy;
		}
		else
		{
			charMap.takeDamage(locX + dx, locY + dy, damage);
			charMap.takeDamage(locX + dx, locY + dy + 1, damage);
		}
	}
}
