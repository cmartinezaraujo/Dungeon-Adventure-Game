package DungeonUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dungeon.Dungeon;
import Dungeon.DungeonAdventure;
import Dungeon.Location;
import Dungeon.Room;
import Factories.Hero;
import Factories.HeroFactory;

class TestDungeonAdventureOptions 
{
	@Test
	void testOptionMove() 
	{
		Dungeon dungeon = new Dungeon();
		Hero hero = HeroFactory.createHero("Ninja");
		Location locationBefore = new Location(2,2);
		
		hero.setLocation(locationBefore);
		dungeon.setLocation(locationBefore);
		
		DungeonAdventure.move(hero, dungeon);
		
		assertNotSame(locationBefore, hero.getLocation());
	}
	
	@Test
	void testOptionUsePotion() 
	{
		Dungeon dungeon = new Dungeon();
		dungeon.setLocation(new Location(2,0));
		Room room = new Room(new Location(2,0));
		Hero hero = HeroFactory.createHero("Ninja");
		hero.setLocation(new Location(2,0));
		
		hero.setHealingPotions(1);
		hero.setVisionPotions(1);
		
		DungeonAdventure.usePotion(hero, dungeon);

		assertEquals(false, (hero.getHealingPotions() == 1 && hero.getVisionPotions() == 1));
	}
	
	@Test
	void testOptionSecretMenu() 
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
