package Factories;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */




public class Warrior extends Hero
{

	Warrior()
	{

		super("Warrior", 125, 4, .8, 35, 60, .2);


	}//end constructor

	@Override
	public void normalAttackPhrase(DungeonCharacter opponent){
		System.out.println(this.getName() + " swings a mighty sword at " +
				opponent.getName() + ":");
	}

	public void battleChoices(DungeonCharacter opponent)
	{
		int choice;
		super.battleChoices(opponent);

		do
		{

			choice = dispalyBattleOptions("Crushing Blow on Opponent");

			switch (choice)
			{
				case 1: normalAttackPhrase(opponent);
					setAttack(AttackFactory.getAttackBehavior("Normal"));
					getAttack().attack((DungeonCharacter)this, opponent);
					break;
				case 2: setAttack(AttackFactory.getAttackBehavior("CrushingBlow"));
					getAttack().attack((DungeonCharacter)this, opponent);

					break;
				default:
					System.out.println("invalid choice!");
			}//end switch

			numTurns--;
			if (numTurns > 0)   // todo add isAlive for this if statement and the while statement below
				System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0);

	}//end battleChoices method

	public void battleChoices(DungeonCharacter opponent, int choice)
	{
		setNumTurns(1);

		do
		{

			switch (choice)
			{
				case 1: normalAttackPhrase(opponent);
					setAttack(AttackFactory.getAttackBehavior("Normal"));
					getAttack().attack((DungeonCharacter)this, opponent);
					break;
				case 2: setAttack(AttackFactory.getAttackBehavior("CrushingBlow"));
					getAttack().attack((DungeonCharacter)this, opponent);

					break;
				default:
					System.out.println("invalid choice!");
			}//end switch

			numTurns--;
			if (numTurns > 0)   // todo add isAlive for this if statement and the while statement below
				System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0);

	}//end battleChoices method

}//end Factories.Hero class