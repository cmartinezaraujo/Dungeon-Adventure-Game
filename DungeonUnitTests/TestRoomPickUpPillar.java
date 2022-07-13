package DungeonUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dungeon.Location;
import Dungeon.Room;
import Factories.Hero;
import Factories.HeroFactory;

class TestRoomPickUpPillar 
{
	@Test
	void testHeroPickingUpPillars() 
	{
		Room tempRoom = new Room(new Location(0,2));
		Hero theHero = HeroFactory.createHero("Ninja");
		
		tempRoom.pickUpPillar(theHero);
		tempRoom.pickUpPillar(theHero);
		tempRoom.pickUpPillar(theHero);
		tempRoom.pickUpPillar(theHero);
		
		assertEquals(true, theHero.hasAllPillars());
	}
}
