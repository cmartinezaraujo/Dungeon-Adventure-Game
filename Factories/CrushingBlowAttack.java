package Factories;

public class CrushingBlowAttack implements AttackBehavior {

    CrushingBlowAttack(){}

    public void attack(DungeonCharacter hero, DungeonCharacter opponent) {

        if (Math.random() <= .4) {
            int blowPoints = (int) (Math.random() * 76) + 100;
            System.out.println(hero.getName() + " lands a CRUSHING BLOW for " + blowPoints
                    + " damage!");
            opponent.subtractHitPoints(blowPoints);
        }//end blow succeeded
        else {
            System.out.println(hero.getName() + " failed to land a crushing blow");
            System.out.println();
        }//blow failed
    }

    @Override
    public String attackType() {
        return "CrushingBlow";
    }
}