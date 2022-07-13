package DungeonUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dungeon.Location;
import Dungeon.Room;
import Factories.Hero;
import Factories.HeroFactory;

class TestRoomEnterRoom 
{
	@Test
	void testEnteringAPitRoom()
	{
		Room theRoom = new Room(new Location(1,0));
		Hero theHero = HeroFactory.createHero("Ninja");
		int hitPoints = theHero.getHitPoints();
		
		while(!theRoom.roomType().equals("P"))
		{
			theRoom = new Room(new Location(1,0));
		}
		
		theRoom.enterRoom(theHero);
		assertEquals(true, hitPoints > theHero.getHitPoints());
	}
	
	@Test
	void testEnteringAMultiItemRoom()
	{
		Room theRoom = new Room(new Location(1,0));
		Hero theHero = HeroFactory.createHero("Ninja");
		int hitPoints = theHero.getHitPoints();
		
		while(!theRoom.roomType().equals("M"))
		{
			theRoom = new Room(new Location(1,0));
		}
		
		theRoom.enterRoom(theHero);
		assertEquals(true, theHero.getVisionPotions() == 1 || theHero.getHealingPotions() == 1
				|| hitPoints > theHero.getHitPoints());
	}
	
	@Test
	void testEnteringAVisionItemRoom()
	{
		Room theRoom = new Room(new Location(1,0));
		Hero theHero = HeroFactory.createHero("Ninja");
		int hitPoints = theHero.getHitPoints();
		
		while(!theRoom.roomType().equals("V"))
		{
			theRoom = new Room(new Location(1,0));
		}
		
		theRoom.enterRoom(theHero);
		assertEquals(1, theHero.getVisionPotions());
	}
	
	@Test
	void testEnteringAHealingItemRoom()
	{
		Room theRoom = new Room(new Location(1,0));
		Hero theHero = HeroFactory.createHero("Ninja");

		
		while(!theRoom.roomType().equals("H"))
		{
			theRoom = new Room(new Location(1,0));
		}
		
		theRoom.enterRoom(theHero);
		assertEquals(1, theHero.getHealingPotions());
	}
	
	@Test
	void testEnteringAMonsterRoom()
	{
		Room theRoom = new Room(new Location(1,0));
		Hero theHero = HeroFactory.createHero("Ninja");
		
		while(!theRoom.roomType().equals("X"))
		{
			theRoom = new Room(new Location(1,0));
		}
		
		theRoom.enterRoom(theHero);
		assertEquals(true, theHero.getHitPoints() <= 0 || theHero.isAlive());
	}
}
