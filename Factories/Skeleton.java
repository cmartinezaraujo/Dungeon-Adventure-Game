package Factories;

import Factories.DungeonCharacter;
import Factories.Monster;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Skeleton extends Monster
{

	Skeleton()
	{
		super("Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50);

	}//end constructor

	@Override
	public void normalAttackPhrase(DungeonCharacter opponent){
		System.out.println(getName() + " slices his rusty blade at " +
				opponent.getName() + ":");
	}

}//end class Factories.Skeleton