package DungeonUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dungeon.Dungeon;
import Dungeon.DungeonAdventure;
import Dungeon.Location;
import Factories.Hero;
import Factories.HeroFactory;

class TestDungeonAdventureSecretMenu 
{
	@Test
	void testMenu() 
	{
		Dungeon dungeon = new Dungeon();
		Location l = new Location(2,0);
		Hero hero = HeroFactory.createHero("Ninja");
		hero.setLocation(l);
		int hitPointsBefore = hero.getHitPoints();
		

		
		DungeonAdventure.secretMenu(hero, dungeon);//Only choose options 2-4

		assertEquals(false, hero.getHitPoints() == hitPointsBefore && hero.getLocation() == l);
	}
}
