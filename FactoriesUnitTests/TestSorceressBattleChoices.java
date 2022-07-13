package FactoriesUnitTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Factories.DungeonCharacter;
import Factories.HeroFactory;
import Factories.MonsterFactory;
import Factories.Sorceress;

import static org.junit.jupiter.api.Assertions.*;

class TestSorceressBattleChoices {

    //created battleChoice in Sorceress that takes parameters instead of user input
    // must comment out readName() in Hero constructor for the test to work

    @Test
    void battleChoices1() {

        DungeonCharacter skel = MonsterFactory.createMonster("skeleton");
        Sorceress sorc = (Sorceress)HeroFactory.createHero("sorceress");

        sorc.battleChoices(skel, 1);

        assertEquals("Normal", sorc.getAttack().attackType());

    }
    @Test
    void battleChoices2() {

        DungeonCharacter skel = MonsterFactory.createMonster("skeleton");
        Sorceress sorc = (Sorceress)HeroFactory.createHero("sorceress");

        int oldHP = sorc.getHitPoints();

        sorc.battleChoices(skel, 2);

        assertEquals(true, oldHP < sorc.getHitPoints());

    }

    @Test
    void battleChoicesInvalid() {

        DungeonCharacter skel = MonsterFactory.createMonster("skeleton");
        Sorceress sorc = (Sorceress)HeroFactory.createHero("sorceress");

        sorc.battleChoices(skel, 1111);

        assertEquals(0, sorc.getNumTurns()); // if the numTurns is 0 that means the
                                                      // method handled the invalid input
    }
}