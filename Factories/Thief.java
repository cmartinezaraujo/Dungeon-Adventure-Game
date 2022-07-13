package Factories;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Thief extends Hero
{

	Thief()
	{
		super("Thief", 75, 6, .8, 20, 40, .5);



	}//end constructor



	public void battleChoices(DungeonCharacter opponent)
	{
		super.battleChoices(opponent);
		int choice;


		do
		{

			choice = dispalyBattleOptions("Surprise Attack");


			switch (choice)
			{
				case 1: setAttack(AttackFactory.getAttackBehavior("Normal"));
					getAttack().attack((DungeonCharacter)this, opponent);

					break;
				case 2: setAttack(AttackFactory.getAttackBehavior("Suprise"));
					getAttack().attack((DungeonCharacter)this, opponent);

					break;
				default:
					System.out.println("invalid choice!");
			}//end switch

			numTurns--;
			if (numTurns > 0)
				System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0);

	}

	public void battleChoices(DungeonCharacter opponent, int choice)
	{
		setNumTurns(1);
		do
		{


			switch (choice)
			{
				case 1: setAttack(AttackFactory.getAttackBehavior("Normal"));
					getAttack().attack((DungeonCharacter)this, opponent);

					break;
				case 2: setAttack(AttackFactory.getAttackBehavior("Surprise"));
					getAttack().attack((DungeonCharacter)this, opponent);

					break;
				default:
					System.out.println("invalid choice!");
			}//end switch

			numTurns--;
			if (numTurns > 0)
				System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0);

	}
}