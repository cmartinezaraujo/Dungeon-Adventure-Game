
package Factories;

import java.util.HashMap;
import java.util.Map;

public class AttackFactory {

    private static Map<String, AttackBehavior> attacks = new HashMap<String, AttackBehavior>();

    public static AttackBehavior getAttackBehavior(String attackName){
        attackName = attackName.toUpperCase();

        AttackBehavior ab = attacks.get(attackName);
        if(ab == null){
            ab = CreateAttackBehavior(attackName);
            attacks.put(attackName, ab);
        }
        return ab;
    }

    private static AttackBehavior CreateAttackBehavior(String attackName){
        if(attackName.equalsIgnoreCase("CrushingBlow"))
            return new CrushingBlowAttack();
        else if(attackName.equalsIgnoreCase("Normal"))
            return new NormalAttack();
        else if(attackName.equalsIgnoreCase("Surprise"))
            return new SurpriseAttack();
        else
            throw new IllegalArgumentException("Invalid attack type");
    }
}