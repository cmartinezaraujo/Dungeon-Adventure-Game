package DungeonUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dungeon.Dungeon;
import Dungeon.DungeonAdventure;
import Dungeon.Location;
import Factories.Hero;
import Factories.HeroFactory;

class TestDungeonAdventureMove 
{
	@Test
	void testMove()
	{
		Dungeon dungeon = new Dungeon();
		Hero hero = HeroFactory.createHero("Ninja");
		Location locationBefore = new Location(2,2);
		
		hero.setLocation(locationBefore);
		dungeon.setLocation(locationBefore);
		
		DungeonAdventure.move(hero, dungeon);
		
		assertNotSame(locationBefore, hero.getLocation());
	}
}
