package DungeonUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Dungeon.Location;

class TestLocationIsValid {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void invalidColumnPositive()
	{
		boolean invalid = new Location(0, 8).isValidLocation();
				
		assertEquals(false, invalid);
	}
	
	@Test
	void invalidColumnNegative()
	{
		boolean invalid = new Location(0, -4).isValidLocation();
				
		assertEquals(false, invalid);
	}
	
	@Test
	void invalidRowPositive()
	{
		boolean invalid = new Location(10, 0).isValidLocation();
				
		assertEquals(false, invalid);
	}
	
	@Test
	void invalidRowNegative()
	{
		boolean invalid = new Location(-23, 0).isValidLocation();
				
		assertEquals(false, invalid);
	}
	
	@Test
	void validLocation()
	{
		boolean invalid = new Location(0, 0).isValidLocation();
				
		assertEquals(true, invalid);
	}

}
