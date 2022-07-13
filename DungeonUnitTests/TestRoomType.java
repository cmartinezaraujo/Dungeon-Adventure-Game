package DungeonUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dungeon.Location;
import Dungeon.Room;
import Factories.Hero;
import Factories.HeroFactory;

class TestRoomType {

	@Test
	void testRoomTypeExit() 
	{
		Room tempRoom = new Room("Exit", new Location(0,2));
		
		assertEquals("O", tempRoom.roomType());
	}
	
	@Test
	void testRoomTypeEntrance() 
	{
		Room tempRoom = new Room("Entrance", new Location(0,2));
		
		assertEquals("I", tempRoom.roomType());
	}

}
