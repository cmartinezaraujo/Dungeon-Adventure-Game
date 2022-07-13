package Dungeon;

import Factories.*;

public class Room 
{

	private int items;
	private Location curLocation;
	private int healingPotions;
	private int visionPotions;
	private boolean pit;
	private boolean pillar;
	private boolean isEntrance;
	private boolean isExit;
	private boolean hasMonster;

	public Room(Location roomLocation)
	{
		this.items = 0;
		
		 if(itemChance("H"))
		 {
			 this.healingPotions = 1;

		 }
		 else 
			 this.healingPotions = 0;
		 
		 if(itemChance("V"))
		 {
			 this.visionPotions = 1;
		 }
		 else 
			 this.visionPotions = 0;
		 
		 if(itemChance("P"))
		 {
			 this.pit = true;
		 }
		 else
			 this.pit = false;
		 
		 if(itemChance("X"))
		 {
			 this.hasMonster = true;
		 }
		 else
			 this.hasMonster = false;
		 
		 this.curLocation = roomLocation;
		 this.isEntrance = false;
		 this.isExit = false;	 
	}
	
	public Room(String specialRoom, Location roomLocation)
	{
		if(specialRoom.equals("Entrance"))
		{
			this.isEntrance = true;
			this.isExit = false;
			this.pillar = false;
		}
		if(specialRoom.equals("Exit"))
		{
			this.isExit = true;
			this.isEntrance = false;
			this.pillar = false;
		}
		if(specialRoom.equals("Pillar"))
		{
			this.items++;
			this.pillar = true;
			this.isEntrance = false;
			this.isExit = false;
		}
		
		this.curLocation = roomLocation;
		this.healingPotions = 0;
		this.visionPotions = 0;
		this.pit = false;
		this.hasMonster = false;
		
	}
	
	private boolean itemChance(String item)
	{
		int itemChance = (int)(Math.random()*((100)+1));
		int percent = 10;
		
		if(item.equalsIgnoreCase("V"))
			percent = 15;
		if(item.equalsIgnoreCase("H"))
			percent = 15;
		if(item.equalsIgnoreCase("X"))
			percent = 15;
		if(item.equalsIgnoreCase("P"))
			percent = 20;


		if(itemChance <= percent)
		{
			this.items++;
			return true;
		}
		return false;
	}
	
	public void useHealingPotion(Hero theHero)
	{
		if(theHero.getHealingPotions() > 0)
		{
		int hitPoints = (int)(Math.random()*((15-5)+1))+5;
		
		theHero.setHitPoints(theHero.getHitPoints() + hitPoints);
		
		this.items--;
		

		System.out.println("The potion you took granted you " + hitPoints + " hit points!");
		
		theHero.setHealingPotions(0);
		
		}
		else
			System.out.println("Sorry it looks like you are out of healing potions!");
	}
	
	public void fallInPit(Hero theHero)
	{
		int hitPoints = (int)(Math.random()*((15-5)+1))+5;
		
		theHero.setHitPoints(theHero.getHitPoints() - hitPoints);
	
		this.items--;
		
		this.pit = false;
		
		System.out.println("You fell into a pit and lost " + hitPoints + " hit points!");
		
	}
	
	public void pickUpPillar(Hero theHero)
	{
		this.items--;
		
		this.pillar = false;
		
		theHero.addPillar();
		
		System.out.println("You have found a pillar of OO!"); //Add code to display 1 of the 4 specific pillars
	}
	
	public void useVisionPotion(Room[][] dungeon, Hero theHero)
	{
		if(theHero.getVisionPotions() > 0)
		{
		System.out.println("Vision potion activated!\n");
		
		if(curLocation.getRow() - 1 >= 0 && curLocation.getCol() -1 >= 0)
			System.out.print(dungeon[curLocation.getRow()  - 1][curLocation.getCol() - 1].roomType());
		
		if(curLocation.getRow() - 1 >= 0)
			System.out.print(dungeon[curLocation.getRow()  - 1][curLocation.getCol()].roomType());
		
		if(curLocation.getRow()  - 1 >= 0 && curLocation.getCol() + 1 <= 4)
			System.out.print(dungeon[curLocation.getRow()  - 1][curLocation.getCol() + 1].roomType() + "\n");
		
		if(curLocation.getCol() -1 >= 0)
			System.out.print(dungeon[curLocation.getRow() ][curLocation.getCol() - 1].roomType());
		
		
		System.out.print(dungeon[curLocation.getRow() ][curLocation.getCol()].roomType());
		
		if(curLocation.getCol() + 1 <= 4)
			System.out.print(dungeon[curLocation.getRow()][curLocation.getCol() + 1].roomType()+ "\n");
		
		if(curLocation.getRow()  + 1 <= 4 && curLocation.getCol() -1 >= 0)
			System.out.print(dungeon[curLocation.getRow()  + 1][curLocation.getCol() -1].roomType());
		
		if(curLocation.getRow()  + 1 <= 4)
			System.out.print(dungeon[curLocation.getRow()  + 1][curLocation.getCol()].roomType());

		
		if(curLocation.getRow()  + 1 <= 4 && curLocation.getCol() +1 <= 4)
			System.out.print(dungeon[curLocation.getRow() + 1][curLocation.getCol() + 1].roomType() + "\n\n");//Change made

		this.items--;
		
		
		theHero.setVisionPotions(0);;
		
		}//End of using potion
		
		else
			System.out.println("Sorry looks like you are out of visbion potions!");
		
		
	}
	
	public void battleMonster(Hero theHero)
	{
		Monster theMonster = DungeonAdventure.generateMonster();
		System.out.println(theHero.getName() + " battles " +
							theMonster.getName());
		System.out.println("---------------------------------------------");

		//do battle
		while (theHero.isAlive() && theMonster.isAlive()) {
			//hero goes first
			theHero.battleChoices(theMonster);

			//monster's turn (provided it's still alive!)
			if (theMonster.isAlive()){
				theMonster.normalAttackPhrase(theHero);
				theMonster.setAttack(AttackFactory.getAttackBehavior("Normal"));
				theMonster.getAttack().attack(theMonster, theHero);
			}

		}//end battle loop

		winLose(theMonster, theHero);
	}
	

	private void winLose(DungeonCharacter theMonster, DungeonCharacter theHero)	
	{

		if (!theMonster.isAlive())
		{
			System.out.println(theHero.getName() + " was victorious!");
			if(itemChance("H"))
			{
				System.out.println("The monster droped a potion!");
				this.healingPotions++;
			}
			
		}
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		
	}
	
	public void enterRoom(Hero theHero)
	{
		if(this.pit)
		{
			fallInPit(theHero);
		}
		
		if(this.hasMonster)
		{
			System.out.println("There is a moster in the room!");
			battleMonster(theHero);
			this.hasMonster = false;
		}
		
		if(this.pillar)
		{
			pickUpPillar(theHero);
		}
		
		
		theHero.setHealingPotions(this.healingPotions);
		if(this.healingPotions > 0)
		{
			this.healingPotions--;
			System.out.println("You picked up a healing potion!");
		}
		
		
		theHero.setVisionPotions(this.visionPotions);
		if(this.visionPotions > 0)
		{
			this.visionPotions--;
			System.out.println("You picked up a vision potion!");
		}

	}
	
	public String roomType()
	{
		if(this.items > 1)
			return "M";
		if(this.isEntrance)
			return "I";
		if(this.isExit)
			return "O";
		if(this.healingPotions > 0)
			return "H";
		if(this.visionPotions > 0)
			return "V";
		if(this.pit)
			return "P";
		if(this.pillar)
			return "?";
		if(this.hasMonster)
			return "X";
		
		return "E";
	}
	
	public boolean isExit()
	{
		return this.isExit;
	}
	
	@Override
	public String toString()
	{
		
		String res = "";
		
		if(this.curLocation.getRow() == 0)
			res += "***\n";
		else
			res += "*-*\n";
		
		if(this.curLocation.getCol()== 0)
			res += "*"+roomType()+"|\n";
		else if(this.curLocation.getCol()== 4)
			res += "|"+roomType()+"*\n";
		else
			res += "|"+roomType()+"|\n";
		
		if(this.curLocation.getRow() == 4)
			res += "***\n";
		else
			res += "*-*\n";
			
		
		
		return res;
	}
	
}
