package DungeonUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dungeon.Location;
import Dungeon.Room;

class TestRoomConstructor {

	@Test
	void testRoomConstructor() 
	{
		Room room = new Room(new Location(1,1));
		boolean normalRoom = room.roomType().equals("E") || room.roomType().equals("H")
				|| room.roomType().equals("V") || room.roomType().equals("X") 
				|| room.roomType().equals("P") || room.roomType().equals("M");
		
		assertEquals(true,normalRoom);
	}

}
