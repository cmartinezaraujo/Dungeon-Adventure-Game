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

public class Gremlin extends Monster
{

	Gremlin()
	{
		super("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40);

	}//end constructor

	@Override
	public void normalAttackPhrase(DungeonCharacter opponent){
		System.out.println(getName() + " jabs his kris at " +
				opponent.getName() + ":");
	}

}//end class Factories.Gremlin