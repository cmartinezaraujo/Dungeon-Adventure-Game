package Dungeon;

public class Dungeon
{
	private Location curLocation;
	private Room[][] theDungeon;
	
	public Dungeon ()
	{
		this.theDungeon = new Room[5][5];
		this.curLocation = new Location(2,0);
		makeDungeon();
	}
	
	private void makeDungeon()
	{
		
		this.theDungeon[2][0] = new Room("Entrance", new Location(2,0));
		
		this.theDungeon[2][4] = new Room("Exit", new Location(2,4));
		
		this.theDungeon[0][0] = new Room("Pillar", new Location(0,0));
		
		this.theDungeon[0][4] = new Room("Pillar", new Location(0,4));
		
		this.theDungeon[1][2] = new Room("Pillar", new Location(1,2));
		
		this.theDungeon[4][2] = new Room("Pillar", new Location(4,2));
		
		for(int x = 0; x < 5; x++)
		{
			for(int y = 0; y < 5; y++)
			{
				if(this.theDungeon[x][y] == null)
				{
					this.theDungeon[x][y] = new Room(new Location(x,y));
				}
			}
		}
		
		
	}
	
	public Room getRoom(Location theRoom)
	{
		return this.theDungeon[theRoom.getRow()][theRoom.getCol()];
	}
	
	public Room[][] getTheDungeon()
	{
		return this.theDungeon;
	}
	
	public Location getLocation()
	{
		return this.curLocation;
	}
	
	public void setLocation(Location newLocation)
	{
		this.curLocation = newLocation;
		
	}
	
	@Override
	public String toString()
	{
		String res = "";
		
		res += "***********\n";
		
		for(int x = 0; x < 5; x++)
		{
			for(int y = 0; y < 5; y++)
			{
				if(y == 0)
					res += "*";
					
				res += theDungeon[x][y].roomType();
				
				if(y < 4)
					res += "|";
				
				if(y == 4)
					res += "*";
			}
			
			if(x != 4)
				res += "\n*-*-*-*-*-*";
			
			res += "\n";
		}
		res += "***********\n";
		
		return  res;
	}
	
}