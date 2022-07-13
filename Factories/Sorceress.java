package Factories;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

import java.util.Scanner;

public class Sorceress extends Hero
{
	public final int MIN_ADD = 25;
	public final int MAX_ADD = 50;

	//-----------------------------------------------------------------
	Sorceress()
	{
		super("Sorceress", 75, 5, .7, 25, 50, .3);


	}//end constructor

	//-----------------------------------------------------------------
	private void increaseHitPoints()
	{
		int hPoints;

		hPoints = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		addHitPoints(hPoints);
		System.out.println(getName() + " added [" + hPoints + "] points.\n"
				+ "Total hit points remaining are: "
				+ getHitPoints());
		System.out.println();

	}//end increaseHitPoints method

	@Override
	public void normalAttackPhrase(DungeonCharacter opponent){
		System.out.println(getName()  + " casts a spell of fireball at " +
				opponent.getName() + ":");
	}
	//-----------------------------------------------------------------
	public void battleChoices(DungeonCharacter opponent)
	{
		int choice;
		super.battleChoices(opponent);

		do
		{
			choice = dispalyBattleOptions("Increase Hit Points");

			switch (choice)
			{
				case 1: normalAttackPhrase(opponent);
					setAttack(AttackFactory.getAttackBehavior("normal"));
					getAttack().attack((DungeonCharacter)this, opponent);
					break;
				case 2: increaseHitPoints();
					break;
				default:
					System.out.println("invalid choice!");
			}//end switch

			numTurns--;
			if (numTurns > 0)
				System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0 && getHitPoints() > 0 && opponent.getHitPoints() > 0);

	}//end overridden method

	public void battleChoices(DungeonCharacter opponent, int choice)
	{
		setNumTurns(1);

		do
		{

			switch (choice)
			{
				case 1: normalAttackPhrase(opponent);
					setAttack(AttackFactory.getAttackBehavior("normal"));
					getAttack().attack((DungeonCharacter)this, opponent);
					break;
				case 2: increaseHitPoints();
					break;
				default:
					System.out.println("invalid choice!");
			}//end switch

			numTurns--;
			if (numTurns > 0)
				System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0 && getHitPoints() > 0 && opponent.getHitPoints() > 0);

	}//end overridden method

}//end class