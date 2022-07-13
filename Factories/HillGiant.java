package Factories;

public class HillGiant extends Monster
{
	public HillGiant()
	{
		super("Bulk the Hill Giant", 90, 4, .9, .4, 20, 30, 15, 30);
	}
	
	@Override
	public void normalAttackPhrase(DungeonCharacter opponent){
		System.out.println(getName() + " swings his giant fist at " +
				opponent.getName() + ":");
	}
}
