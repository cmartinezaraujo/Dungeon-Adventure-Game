package DungeonUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dungeon.Dungeon;
import Dungeon.DungeonAdventure;
import Dungeon.Location;
import Factories.Hero;
import Factories.HeroFactory;

class TestDungeonAdventureUpdateLocation 
{
	@Test
	void testUpdatingWithValidLocation() 
	{
		Dungeon dungeon = new Dungeon();
		Hero hero = HeroFactory.createHero("Ninja");
		Location locationBefore = new Location(2,0);
		
		hero.setLocation(locationBefore);
		dungeon.setLocation(locationBefore);
		
		Location newLocation = new Location(3,0);
		
		DungeonAdventure.updateLocation(newLocation, hero, dungeon);;
		
		assertEquals(newLocation, hero.getLocation());
	}
	
	@Test
	void testUpdatingWithInvalidLocation() 
	{
		Dungeon dungeon = new Dungeon();
		Hero hero = HeroFactory.createHero("Ninja");
		Location locationBefore = new Location(2,0);
		
		hero.setLocation(locationBefore);
		dungeon.setLocation(locationBefore);
		
		Location newLocation = new Location(9,0);
		
		DungeonAdventure.updateLocation(newLocation, hero, dungeon);;
		
		assertEquals(locationBefore, hero.getLocation());
	}
}
