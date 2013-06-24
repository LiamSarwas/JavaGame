import java.awt.Color;


public class Block {

	private int type;
	private int health;
	
	public Block(int newType)
	{
		type = newType;
		if(newType == 0)
		{
			//air
			health = 0;
		}
		if(newType == 1)
		{
			//dirt
			health = 40;
		}
		if(newType == 2)
		{
			//stone
			health = 80;
		}
		if(newType == 3)
		{
			//other stone
			health = 120;
		}
	}
	
	public int getType()
	{
		//returns the block ID of the block
		return type;
	}
	public void setType(int newType)
	{
		//sets the block ID of the block
		type = newType;
	}
	public int getHealth()
	{
		//return the health of a block
		return health;
	}
	public void setHealth(int damage)
	{
		if(health > 0)
		{
			health = health - damage;
		}
	}
}
