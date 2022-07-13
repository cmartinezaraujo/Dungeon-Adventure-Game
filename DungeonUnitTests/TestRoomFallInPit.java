package DungeonUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dungeon.Location;
import Dungeon.Room;
import Factories.Hero;
import Factories.HeroFactory;

class TestRoomFallInPit 
{
	@Test
	void testHeroFallsInPit() 
	{
		Room tempRoom = new Room(new Location(0,2));
		Hero theHero = HeroFactory.createHero("Ninja");
		int hitPointsBefore = theHero.getHitPoints();
		tempRoom.fallInPit(theHero);
		int hitPointsAfter = theHero.getHitPoints();
		
		assertEquals(true, hitPointsAfter < hitPointsBefore);

	}
}
