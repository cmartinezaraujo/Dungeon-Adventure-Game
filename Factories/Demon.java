package Factories;

public class Demon extends Monster
{
	public Demon()
	{
		super("Asmodeus the Demon", 80, 5, .6, .6, 15, 25, 10, 20);
	}
	
	@Override
	public void normalAttackPhrase(DungeonCharacter opponent){
		System.out.println(getName() + " attacks " +
				opponent.getName() + ":");
	}
}
