package DungeonUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dungeon.Dungeon;
import Dungeon.Location;

class TestDungeonSetLocation {

	@Test
	void testSettingLocation() 
	{
		Dungeon theDungeon = new Dungeon();
		
		Location newLocation = new Location(0,0);
		theDungeon.setLocation(newLocation);
		assertEquals(newLocation, theDungeon.getLocation());
		
		newLocation = new Location(2,0);
		theDungeon.setLocation(newLocation);
		assertEquals(newLocation, theDungeon.getLocation());
		
		newLocation = new Location(4,4);
		theDungeon.setLocation(newLocation);
		assertEquals(newLocation, theDungeon.getLocation());
	}
}
