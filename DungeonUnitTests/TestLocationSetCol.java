package DungeonUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dungeon.Location;

class TestLocationSetCol 
{
	@Test
	void testSettingLocationColumn() 
	{
		Location newLocation = new Location(0,0);
		
		newLocation.setCol(2);
		assertEquals(2, newLocation.getCol() );
		
		newLocation.setCol(4);
		assertEquals(4, newLocation.getCol() );
		
		newLocation.setCol(3);
		assertEquals(3, newLocation.getCol() );
		
		newLocation.setCol(1);
		assertEquals(1, newLocation.getCol() );
	}
}
