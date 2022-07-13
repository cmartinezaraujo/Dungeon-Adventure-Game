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

public class Ogre extends Monster
{

	Ogre()
	{
		super("Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 50);


	}//end constructor


	@Override
	public void normalAttackPhrase(DungeonCharacter opponent){
		System.out.println(getName() + " slowly swings a club toward's " +
				opponent.getName() + ":");
	}

}//end Monsters.Monster class