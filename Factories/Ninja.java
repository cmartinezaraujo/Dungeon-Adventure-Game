package Factories;

public class Ninja extends Hero
{
	Ninja()
	{
		super("Ninja", 100, 5, .9, 40, 65, .4);
	}
	
	@Override
	public void normalAttackPhrase(DungeonCharacter opponent){
		System.out.println(this.getName() + " throws a ninja star at " +
				opponent.getName() + ":");
	}
	
	public void battleChoices(DungeonCharacter opponent)
	{
		int choice;
		super.battleChoices(opponent);

		do
		{

			choice = dispalyBattleOptions("Surprise Attack");

			switch (choice)
			{
				case 1: normalAttackPhrase(opponent);
					setAttack(AttackFactory.getAttackBehavior("Normal"));
					getAttack().attack((DungeonCharacter)this, opponent);
					break;
					
				case 2: setAttack(AttackFactory.getAttackBehavior("Surprise"));
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
}
