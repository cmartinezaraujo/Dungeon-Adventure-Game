package DungeonUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dungeon.Location;
import Dungeon.Room;

class TestSpecialRoomConstructor {

	@Test
	void testSpecialRoomConstructorEntrance() 
	{
		Room room = new Room("Entrance", new Location(0,0));
		
		assertEquals(true, room.roomType().equals("I"));
		
	}
	
	void testSpecialRoomConstructorExit() 
	{
		Room room = new Room("Entrance", new Location(0,0));
		
		assertEquals(true, room.roomType().equals("O"));
		
	}
	
	void testSpecialRoomConstructorPillar() 
	{
		Room room = new Room("Pillar", new Location(0,0));
		
		assertEquals(true, room.roomType().equals("?"));
		
	}

}
