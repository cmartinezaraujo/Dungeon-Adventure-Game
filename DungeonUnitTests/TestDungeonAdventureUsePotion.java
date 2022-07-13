package DungeonUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dungeon.Dungeon;
import Dungeon.DungeonAdventure;
import Dungeon.Location;
import Dungeon.Room;
import Factories.Hero;
import Factories.HeroFactory;

class TestDungeonAdventureUsePotion 
{
	@Test
	void testUsingPotion() 
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
}
