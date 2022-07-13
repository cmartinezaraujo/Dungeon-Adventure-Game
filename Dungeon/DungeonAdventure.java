package Dungeon;
import Factories.Hero;
import Factories.HeroFactory;
import Factories.Keyboard;
import Factories.Monster;
import Factories.MonsterFactory;

public class DungeonAdventure 
{
	public static void main(String[] args)
	{

		Hero theHero;

		intro();
		Dungeon dungeon = new Dungeon();
		theHero = chooseHero();
		theHero.setLocation(new Location(2,0));
		boolean isLiveGame = true;
		
		do
		{
			System.out.print("------------------------------------------------\n");
			System.out.println("Current room:");
			System.out.println(dungeon.getRoom(theHero.getLocation()));
			
			dungeon.getRoom(theHero.getLocation()).enterRoom(theHero);
			
			if(theHero.getHitPoints() <= 0)
			{
				isLiveGame = false;
			}
			else
			{
				System.out.println("\n");
				System.out.println("Current player stats: \n");
				System.out.println(theHero + "\n");
				options(theHero,dungeon);
			}
			
			if(dungeon.getRoom(theHero.getLocation()).isExit())
			{
				isLiveGame = keepPlaying();
			}
		} while (isLiveGame);
		endGame(theHero);
    }//end main method
	

	/*-------------------------------------------------------------------
	options will ask a user for what they wish to do in the current turn
	and call the t
	---------------------------------------------------------------------*/
	public static void options(Hero theHero, Dungeon dungeon)
	{
		System.out.println("Options: ");
		System.out.println("1. Move\n"
				+ "2. Use a potion\n"
				+ "3. Help\n"
				+ "4. Secret menu");
		System.out.print("Choice---> ");
		int choice = Keyboard.readInt();
		System.out.println("\n");
		
		switch(choice)
		{
			case 1: move(theHero,dungeon);
			break;

			case 2: usePotion(theHero, dungeon);
			break;
			
			case 3: help();
			break;
			
			case 4: secretMenu(theHero, dungeon) ;
			break;

		}//end switch
	}//end chooseHero method
	
	
	public static void move(Hero theHero, Dungeon dungeon)
	{
		Location newLocation = new Location(theHero.getLocation().getRow(),theHero.getLocation().getCol());
		
		System.out.println("1. Move North");
		System.out.println("2. Move South");
		System.out.println("3. Move East");
		System.out.println("4. Move West");
		System.out.print("Choice---> ");
		
		int choice = Keyboard.readInt();
		
		System.out.println("\n");

		switch(choice)
		{
			case 1: newLocation.setRow(newLocation.getRow()-1);//Up
			updateLocation(newLocation, theHero, dungeon);
			break;

			case 2: newLocation.setRow(newLocation.getRow()+1);//Down
			updateLocation(newLocation, theHero, dungeon);
			break;

			case 3: newLocation.setCol(newLocation.getCol()+1);//Left
			updateLocation(newLocation, theHero, dungeon);
			break;

			default: newLocation.setCol(newLocation.getCol()-1);//Right
			updateLocation(newLocation, theHero, dungeon);
			break;
		}//end switch
	}//end chooseHero method
	
	
	public static void usePotion (Hero theHero, Dungeon dungeon)
	{
		System.out.println("1. Use healing potion");
		System.out.println("2. Use vision potion");
		System.out.print("Choice---> ");
		
		int choice = Keyboard.readInt();
		
		System.out.println("\n");
		
		switch(choice)
		{
			case 1: dungeon.getRoom(theHero.getLocation()).useHealingPotion(theHero);
			break;

			case 2: dungeon.getRoom(theHero.getLocation()).useVisionPotion(dungeon.getTheDungeon(), theHero);
			break;

		}//end switch
	}
	
	public static void secretMenu(Hero theHero, Dungeon dungeon)
	{
		System.out.println("Secret menu options");
		System.out.println("1. Print the whole dungeon\n"
				+ "2. Set hit points to 5000\n"
				+ "3. Teleport to exit\n"
				+ "4. Set hit points to 0 (kill the hero)\n");
		
		int choice = Keyboard.readInt();
		
		switch(choice)
		{
			case 1: System.out.println(dungeon);
			break;
			
			case 2: theHero.setHitPoints(5000);
			break;
			
			case 3: theHero.setLocation(new Location(2,4));
			break;
			
			case 4: theHero.setHitPoints(0);
			break;

		}//end switch
	}
	
	public static void updateLocation(Location newLocation, Hero theHero, Dungeon dungeon)
	{
		if(newLocation.isValidLocation())
		{
			theHero.setLocation(newLocation);
			dungeon.setLocation(theHero.getLocation());
		}
		else
			System.out.println("OOPS you ran into a wall");
	}
	

/*-------------------------------------------------------------------
chooseHero allows the user to select a hero, creates that hero, and
returns it.  It utilizes a polymorphic reference (Factories.Hero) to accomplish
this task
---------------------------------------------------------------------*/
	public static Hero chooseHero()
	{
		int choice;
		Hero theHero;

		System.out.println("Choose a hero:\n" +
					       "1. Warrior\n" +
						   "2. Sorceress\n" +
						   "3. Thief\n" +
						   "4. Ninja\n" +
						   "5. Wizard");
		choice = Keyboard.readInt();

		switch(choice)
		{
			case 1: return HeroFactory.createHero("Warrior");

			case 2: return HeroFactory.createHero("Sorceress");

			case 3: return HeroFactory.createHero("Thief");
			
			case 4: return HeroFactory.createHero("Ninja");
			
			case 5: return HeroFactory.createHero("Wizard");

			default: System.out.println("invalid choice, returning Factories.Thief");
				     return HeroFactory.createHero("Thief");
		}//end switch
	}//end chooseHero method

/*-------------------------------------------------------------------
generateMonster randomly selects a Monsters.Monster and returns it.  It utilizes
a polymorphic reference (Monsters.Monster) to accomplish this task.
---------------------------------------------------------------------*/
	public static Monster generateMonster()
	{
		int choice;

		choice = (int)(Math.random() * 5) + 1;

		switch(choice)
		{
			case 1: return MonsterFactory.createMonster("Ogre");

			case 2: return MonsterFactory.createMonster("Skeleton");

			case 3: return MonsterFactory.createMonster("Gremlin");
			
			case 4: return MonsterFactory.createMonster("Hill Giant");
			
			case 5: return MonsterFactory.createMonster("Demon");

			default: System.out.println("invalid choice, returning Skeleton");
				     return MonsterFactory.createMonster("Skeleton");
		}//end switch
	}//end generateMonster method

/*-------------------------------------------------------------------
keepPlaying will be triggered if the exit in the dungeon is entered. The 
player will be asked if they wish to exit the dungeon and return true or
false.
---------------------------------------------------------------------*/
	public static boolean keepPlaying()
	{
		char again;

		System.out.println("You have found the exit! Would you like to exit (y/n)?");
		again = Keyboard.readChar();

		return (again == 'N' || again == 'n');
	}//end playAgain method
	
	public static void intro()
	{
		System.out.println("Welcome to Dungeon Adventure!\n"
				+ "Navigate through the dungeon and try to\n"
				+ "find all the pillars of OO. If you survive\n"
				+ "and make it to the exit with all the pillars,\n"
				+ "you win!\n");
	}
	
	/*-------------------------------------------------------------------
	endGame will let the player know if they won or lost if they lost and
	why.
	---------------------------------------------------------------------*/
	public static void endGame(Hero theHero)
	{
		if(theHero.hasAllPillars() && theHero.getHitPoints() > 0)
		{
			System.out.println("You survived and found all the pillars of OO you have won the game!");
		}
		else if(theHero.getHitPoints() <= 0)
		{
			System.out.println("Unfortunately you died before you could make it out of the dungeon with all the pillars of OO. ");
		}
		else
			System.out.println("Unfortunatly you did not find all the pillars of OO before leaving the dungeon and have lost the game.");
	}
	
	public static void help()
	{
		System.out.println("Room types:\n"
				+ "M = Room has multiple items\n"
				+ "I = Room is an entrance\n"
				+ "O = Room is an exit\n"
				+ "H = Room has a healing potion\n"
				+ "V = Room has a vision potion\n"
				+ "P = Room has a pit\n"
				+ "? = Room has a pillar\n"
				+ "X = Room has a monster\n"
				+ "E = Room is empty");
	}

}
