package Factories;

public class SurpriseAttack implements AttackBehavior{

    SurpriseAttack(){}

    public void attack(DungeonCharacter hero, DungeonCharacter opponent){

        Hero heroObj = (Hero)hero;

        double surprise = Math.random();
        if (surprise <= .4)
        {
            System.out.println("Surprise attack was successful!\n" +
                    hero.getName() + " gets an additional turn.");
            heroObj.setNumTurns(heroObj.getNumTurns() + 1);

            hero.setAttack(new NormalAttack());
            hero.getAttack().attack(hero, opponent);
        }//end surprise
        else if (surprise >= .9)
        {
            System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
                    " blocked your attack!");
        }
        else {
            hero.setAttack(new NormalAttack());
            hero.getAttack().attack(hero, opponent);
        }

    }

    @Override
    public String attackType() {
        return "Surprise";
    }

}