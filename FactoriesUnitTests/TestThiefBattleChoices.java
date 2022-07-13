package FactoriesUnitTests;

import org.junit.jupiter.api.Test;

import Factories.DungeonCharacter;
import Factories.HeroFactory;
import Factories.MonsterFactory;
import Factories.Thief;

import static org.junit.jupiter.api.Assertions.*;

class TestThiefBattleChoices {

    //created battleChoice in Thief that takes parameters instead of user input
    // must comment out readName() in Hero constructor for the test to work

    @Test
    void battleChoices1() {

        DungeonCharacter skel = MonsterFactory.createMonster("skeleton");
        Thief thief = (Thief)HeroFactory.createHero("thief");

        thief.battleChoices(skel, 1);

        assertEquals("Normal", thief.getAttack().attackType());

    }
    @Test
    void battleChoices2() {

        DungeonCharacter skel = MonsterFactory.createMonster("skeleton");
        Thief thief = (Thief)HeroFactory.createHero("thief");

        thief.battleChoices(skel, 2);

        assertEquals("Surprise", thief.getAttack().attackType());

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