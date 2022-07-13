package DungeonUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dungeon.DungeonAdventure;
import Factories.Hero;

class TestDungeonAdventureChooseHero 
{
	@Test
	void testMakingAHero() 
	{
		Hero theHero = DungeonAdventure.chooseHero();
		
		assertEquals(true, theHero instanceof Hero);
	}
}
