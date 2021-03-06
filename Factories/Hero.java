package Factories;

import Dungeon.Location;
import Factories.DungeonCharacter;

/**
 * Title: Factories.Hero.java
 *
 * Description: Abstract base class for a hierarchy of heroes.  It is derived
 *  from Factories.DungeonCharacter.  A Factories.Hero has battle choices: regular attack and a
 *  special skill which is defined by the classes derived from Factories.Hero.
 *
 *  class variables (all are directly accessible from derived classes):
 *    chanceToBlock -- a hero has a chance to block an opponents attack
 *    numTurns -- if a hero is faster than opponent, their is a possibility
 *                for more than one attack per round of battle
 *
 *  class methods (all are public):
 *    public Factories.Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
	  public void readName()
	  public boolean defend()
	  public void subtractHitPoints(int hitPoints)
	  public void battleChoices(Factories.DungeonCharacter opponent)

 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */


public abstract class Hero extends DungeonCharacter
{
	protected double chanceToBlock;
	protected int numTurns;
	private int healingPotions;
	private int visionPotions;
	private int pillars;
	private Location heroLocation;
	
//-----------------------------------------------------------------
//calls base constructor and gets name of hero from user
  public Hero(String name, int hitPoints, int attackSpeed,
			  double chanceToHit, int damageMin, int damageMax,
			  double chanceToBlock)
  {
	super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
	this.chanceToBlock = chanceToBlock;
	readName();
  }
  
  public void setLocation(Location newLocation)
  {
	  this.heroLocation = newLocation;
  }
  
  public Location getLocation()
  {
	  return this.heroLocation;
  }
  
  public void setHealingPotions(int potions)
  {
	  this.healingPotions = potions;
  }
  
  public void setVisionPotions(int potions)
  {
	  this.visionPotions = potions;
  }
  
  public int getHealingPotions() 
  {
	  return this.healingPotions;
  }
  
  public int getVisionPotions()
  {
	  return this.visionPotions;
  }
  
  public boolean hasAllPillars()
  {
	  return this.pillars == 4;
  }
  
  public void addPillar()
  {
	  this.pillars++;
  }

	public int getNumTurns() {
		return numTurns;
	}

	public void setNumTurns(int numTurns) {
		this.numTurns = numTurns;
	}
  

/*-------------------------------------------------------
readName obtains a name for the hero from the user

Receives: nothing
Returns: nothing

This method calls: nothing
This method is called by: hero constructor
---------------------------------------------------------*/
  private void readName()
  {
		System.out.print("Enter character name: ");
		this.setName(Keyboard.readString());
  }//end readName method

/*-------------------------------------------------------
defend determines if hero blocks attack

Receives: nothing
Returns: true if attack is blocked, false otherwise

This method calls: Math.random()
This method is called by: subtractHitPoints()
---------------------------------------------------------*/
  private boolean defend()
  {
		return Math.random() <= chanceToBlock;
  }//end defend method

/*-------------------------------------------------------
subtractHitPoints checks to see if hero blocked attack, if so a message
is displayed, otherwise base version of this method is invoked to
perform the subtraction operation.  This method overrides the method
inherited from Factories.DungeonCharacter promoting polymorphic behavior

Receives: hit points to subtract
Returns: nothing

This method calls: defend() or base version of method
This method is called by: attack() from base class
---------------------------------------------------------*/
public void subtractHitPoints(int hitPoints)
	{
		if (defend())
			System.out.println(getName() + " BLOCKED the attack!");
		else
			super.subtractHitPoints(hitPoints);
	}//end method

/*-------------------------------------------------------
battleChoices will be overridden in derived classes.  It computes the
number of turns a hero will get per round based on the opponent that is
being fought.  The number of turns is reported to the user.  This stuff might
go better in another method that is invoked from this one...

Receives: opponent
Returns: nothing

This method calls: getAttackSpeed()
This method is called by: external sources
---------------------------------------------------------*/
	public void battleChoices(DungeonCharacter opponent)
	{
	    numTurns = getAttackSpeed()/opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

	}//end battleChoices

	protected int dispalyBattleOptions(String specialAbility){

		System.out.println("1. Attack Opponent");
		System.out.println("2. " + specialAbility);
		System.out.print("Choose an option: ");
		return Keyboard.readInt();

	}
	
	@Override
	public String toString()
	{
		String res = "";
		
		res += "Name: " + this.getName() + "\n";
		res += "Hit Points: " + this.getHitPoints() + "\n";
		res += "Healing Potions: " + this.healingPotions + "\n";
		res += "Vision Potions: " + this.visionPotions + "\n";
		res += "Pillars found: " + this.pillars + "/" + "4";
		
		return res;
	}
}//end Factories.Hero class