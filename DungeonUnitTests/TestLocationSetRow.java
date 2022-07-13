package DungeonUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dungeon.Location;

class TestLocationSetRow 
{
	@Test
	void testSetingLocationROw()
	{
		Location newLocation = new Location(0,0);
		
		newLocation.setRow(2);
		assertEquals(2, newLocation.getRow() );
		
		newLocation.setRow(4);
		assertEquals(4, newLocation.getRow() );
		
		newLocation.setRow(3);
		assertEquals(3, newLocation.getRow() );
		
		newLocation.setRow(1);
		assertEquals(1, newLocation.getRow() );
	}
}
