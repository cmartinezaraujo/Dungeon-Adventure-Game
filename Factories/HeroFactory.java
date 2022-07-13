package Factories;

public class HeroFactory {

    public static Hero createHero(String name){
        if(name.equalsIgnoreCase("Sorceress"))
            return new Sorceress();
        else if(name.equalsIgnoreCase("Thief"))
            return new Thief();
        else if(name.equalsIgnoreCase("Warrior"))
            return new Warrior();
        else if(name.equalsIgnoreCase("Ninja"))
        	return new Ninja();
        else if(name.equalsIgnoreCase("Wizard"))
            return new Wizard();
        else {
            System.out.println("invalid Hero name... returning Warrior");
            return new Warrior();
        }

    }
}
