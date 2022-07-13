package Factories;

public class Wizard extends Hero
{
	public final int MIN_ADD = 0;
	public final int MAX_ADD = 60;
	
	Wizard()
	{
		super("Sorceress", 80, 4, .6, 30, 45, .2);
	}
	
	public void increaseHitPoints()
	{
		int hPoints;

		hPoints = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		addHitPoints(hPoints);
		String spellRes;
		
		if(hPoints == 0)
			spellRes = " spell failed and added ";
		else
			spellRes = " spess was a sucess and added ";
			
		System.out.println(getName() + spellRes + "[" + hPoints + "] points.\n"
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
}
