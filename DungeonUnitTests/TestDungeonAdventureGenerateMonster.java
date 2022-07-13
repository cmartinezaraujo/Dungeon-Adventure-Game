package DungeonUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dungeon.DungeonAdventure;
import Factories.Monster;

class TestDungeonAdventureGenerateMonster 
{
	@Test
	void test() 
	{
		Monster theMonster = DungeonAdventure.generateMonster();
		
		assertEquals(true, theMonster instanceof Monster);
	}
}
