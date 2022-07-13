package DungeonUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dungeon.Dungeon;
import Dungeon.Location;
import Dungeon.Room;

class TestDungeonConstructor 
{
	@Test
	void testDungeonArray() 
	{
		Dungeon theDungeon = new Dungeon();
		
		for(int x = 0; x < 5; x++)
		{
			for(int y = 0; y < 5; y++)
			{
				assertEquals(true,theDungeon.getTheDungeon()[x][y] instanceof Room);
			}
		}
	}
	
	@Test
	void testDungeonLocation()
	{
		Dungeon theDungeon = new Dungeon();
		Location location = theDungeon.getLocation();
		assertEquals(true, location.getRow() == 2 && location.getCol() == 0);
	}
	
}
