package DungeonUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dungeon.Location;
import Dungeon.Room;
import Factories.Hero;
import Factories.HeroFactory;

class TestRoomUseHealingPotion 
{
	@Test
	void testUsingAHealingPotion() 
	{
		Room tempRoom = new Room(new Location(0,2));
		Hero theHero = HeroFactory.createHero("Ninja");
		theHero.setHealingPotions(1);
		
		int hitPointsBefore = theHero.getHitPoints();
		tempRoom.useHealingPotion(theHero);
		int hitPointsAfter = theHero.getHitPoints();
		
		assertEquals(true, hitPointsAfter > hitPointsBefore);
	}
	
	@Test
	void testHeroHasNoPotionsLeft() 
	{
		Room tempRoom = new Room(new Location(0,2));
		Hero theHero = HeroFactory.createHero("Ninja");
		theHero.setHealingPotions(0);
		
		int hitPointsBefore = theHero.getHitPoints();
		tempRoom.useHealingPotion(theHero);

		
		assertEquals(true, theHero.getHitPoints() == hitPointsBefore);
	}
}
