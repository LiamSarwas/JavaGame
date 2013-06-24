import java.util.Random;


public class Map {
	
	private int width = 0;
	private int height = 0;
	private Block[][] theMap;
	
	public Map(int x, int y)
	{
		//constructor for the map class
		width = x;
		height = y;
		theMap = new Block[x][y];
		generateMap();
	}
	
	public int getWidth()
	{
		//returns the map's width
		return width;
	}
	
	public int getHeight()
	{
		//returns the map's height
		return height;
	}
	
	public void setValue(int x, int y, Block block)
	{
		//sets the block value for a specific block
		theMap[x][y] = block;
	}
	
	public Block getValue(int x, int y)
	{
		//returns the Block at a specific location
		return theMap[x][y];
	}
	
	private Block[][] generateMap()
	
	{
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				//goes through the map, generating a layer of air, layer of dirt, and then a mixed layer of stone 1 and stone 2
				if(j < 6)
				{
					theMap[i][j] = new Block(0);

				}
				else if(j >= 6 && j <= 8)
				{
					theMap[i][j] = new Block(1);
				}
				else
				{
					Random random = new Random();
					theMap[i][j] = new Block(random.nextInt(2) + 2);
				}
			}
		}	
		return theMap;
	}

	public boolean isValid(int x, int y)
	{
		//determines whether a particular location is a valid location to put someone/something
		if(x > -1 && x < width && y > -1 && y < height)
		{
			if(theMap[x][y].getType() != 0)
			{
				return false;
			}
			else
			{
				return true;
			}
			
		}
		return false;
	}

	public void takeDamage(int x, int y, int damage)
	{
		if(x > -1 && x < width && y > -1 && y < height && theMap[x][y].getHealth() > 0)
		{
			theMap[x][y].setHealth(damage);
			if(theMap[x][y].getHealth() <= 0)
			{
				theMap[x][y].setType(0);
			}
		}
	}
	
	public String toString()
	{
		String mapString = "";
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				mapString += theMap[i][j].getHealth() + " ";
			}
			mapString += "\n";	
		}
		return mapString;
	}
	
}
