package DungeonUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dungeon.Dungeon;
import Dungeon.Location;
import Dungeon.Room;
import Factories.Hero;
import Factories.HeroFactory;

class TestRoomUseVisionPotion 
{	
	@Test
	void testHeroUsingVisionPotion() 
	{
		Dungeon theDungeon = new Dungeon();
		Room tempRoom = new Room(new Location(0,2));
		Hero theHero = HeroFactory.createHero("Ninja");
		theHero.setVisionPotions(1);
		
		tempRoom.useVisionPotion(theDungeon.getTheDungeon(), theHero);
		
		
		assertEquals(0, theHero.getVisionPotions());
	}
}


