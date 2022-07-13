package DungeonUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dungeon.Location;

class TestLocationConstructor {

	@Test
	void testLocationConstructor() 
	{
		Location loc = new Location(2,1);
		
		assertEquals(2, loc.getRow());
		assertEquals(1, loc.getCol());
		
		loc = new Location(4,2);
		
		assertEquals(4, loc.getRow());
		assertEquals(2, loc.getCol());
		
		loc = new Location(3,0);
		
		assertEquals(3, loc.getRow());
		assertEquals(0, loc.getCol());
	}

}
