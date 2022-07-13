package FactoriesUnitTests;

import org.junit.jupiter.api.Test;

import Factories.DungeonCharacter;
import Factories.HeroFactory;
import Factories.MonsterFactory;
import Factories.Thief;
import Factories.Warrior;

import static org.junit.jupiter.api.Assertions.*;

class TestWarriorBattleChoices {

    //created battleChoice in warrior that takes parameters instead of user input
    // MUST comment out readName() in Hero constructor for the test to work


    @Test
    void battleChoices1() {

        DungeonCharacter skel = MonsterFactory.createMonster("skeleton");
        Warrior war = (Warrior)HeroFactory.createHero("Warrior");

        war.battleChoices(skel, 1);

        assertEquals("Normal", war.getAttack().attackType());

    }
    @Test
    void battleChoices2() {

        DungeonCharacter skel = MonsterFactory.createMonster("skeleton");
        Warrior war = (Warrior)HeroFactory.createHero("Warrior");

        war.battleChoices(skel, 2);

        assertEquals("CrushingBlow", war.getAttack().attackType());

    }

    @Test
    void battleChoicesInvalid() {

        DungeonCharacter skel = MonsterFactory.createMonster("skeleton");
        Thief thief = (Thief)HeroFactory.createHero("thief");

        thief.battleChoices(skel, 3);

        assertEquals(0, thief.getNumTurns()); // if the numTurns is 0 that means the
                                                        // method handled the invalid input
    }
}