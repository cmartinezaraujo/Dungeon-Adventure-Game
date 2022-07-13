package Factories;

public interface AttackBehavior {
    void attack(DungeonCharacter hero, DungeonCharacter opponent);

    String attackType();
}