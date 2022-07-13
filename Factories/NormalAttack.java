package Factories;

public class NormalAttack implements AttackBehavior{

    NormalAttack(){}

    public void attack(DungeonCharacter hero, DungeonCharacter opponent){
        boolean canAttack;
        int damage;

        canAttack = Math.random() <= hero.getChanceToHit();

        if (canAttack)
        {
            damage = (int)(Math.random() * (hero.getDamageMax() - hero.getDamageMin() + 1))
                    + hero.getDamageMax() ;
            opponent.subtractHitPoints(damage);



            System.out.println();
        }//end if can attack
        else
        {

            System.out.println(hero.getName() + "'s attack on " + opponent.getName() +
                    " failed!");
            System.out.println();
        }//end else
    }

    @Override
    public String attackType() {
        return "Normal";
    }
}