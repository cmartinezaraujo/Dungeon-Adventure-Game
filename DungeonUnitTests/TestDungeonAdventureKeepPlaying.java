package DungeonUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dungeon.DungeonAdventure;

class TestDungeonAdventureKeepPlaying 
{
	@Test
	void testKeepPlaying() 
	{
		System.out.println("Pick Y");
		boolean choice = DungeonAdventure.keepPlaying(); //Choose yes
		
		assertEquals(false, choice);
	}
	
	@Test
	void testDoNotKeepPlaying() 
	{
		System.out.println("Pick N");
		boolean choice = DungeonAdventure.keepPlaying(); //Choose np
		
		assertEquals(true, choice);
	}
}
