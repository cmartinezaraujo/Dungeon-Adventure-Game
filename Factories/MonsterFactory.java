package Factories;

public class MonsterFactory {

    public static Monster createMonster(String name){
        if(name.equalsIgnoreCase("Ogre"))
            return new Ogre();
        else if(name.equalsIgnoreCase("Skeleton"))
            return new Skeleton();
        else if(name.equalsIgnoreCase("Gremlin"))
            return new Gremlin();
        else if(name.equalsIgnoreCase("Hill Ginat"))
        	return new HillGiant();
        else if(name.equalsIgnoreCase("Demon"))
        		return new Demon();
        else {
            System.out.println("invalid monster name... returning Gremlin");
            return new Gremlin();
        }

    }
}
