package DungeonUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dungeon.Location;
import Dungeon.Room;

class TestRoomIsExit 
{
	@Test
	void testRoomIsAnExit() 
	{
		Room tempRoom = new Room("Exit", new Location(0,2));
		assertEquals(true, tempRoom.isExit());
	}
	
	@Test
	void testRoomIsNotAnExit() 
	{
		Room tempRoom = new Room("Entrance", new Location(0,2));
		assertEquals(false, tempRoom.isExit());
	}
}
