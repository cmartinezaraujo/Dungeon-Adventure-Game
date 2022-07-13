package DungeonUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dungeon.Location;
import Dungeon.Room;
import Factories.Hero;
import Factories.HeroFactory;

class TestRoomBattleMonster {

	@Test
	void testBattling() 
	{
		Room theRoom = new Room(new Location(1,0));
		Hero theHero = HeroFactory.createHero("Wizard");
		
		theRoom.battleMonster(theHero);
		
		assertEquals(true, theHero.getHitPoints() <= 0 || theHero.isAlive());
	}

}
