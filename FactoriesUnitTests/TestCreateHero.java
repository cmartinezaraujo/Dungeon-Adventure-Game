package FactoriesUnitTests;

import org.junit.jupiter.api.Test;

import Factories.Hero;
import Factories.HeroFactory;
import Factories.Ninja;
import Factories.Sorceress;
import Factories.Thief;
import Factories.Warrior;
import Factories.Wizard;

import static org.junit.jupiter.api.Assertions.*;

class TestCreateHero {

    // MUST comment out readName() in Hero constructor for the test to work

    @Test
    void createHeroSorceress() {
        Hero directCreateSorceress = new Sorceress();

        assertEquals(directCreateSorceress.getName(), HeroFactory.createHero("sorceress").getName());
    }

    @Test
    void createHeroThief() {
        Hero directCreateThief = new Thief();

        assertEquals(directCreateThief.getName(), HeroFactory.createHero("Thief").getName());
    }

    @Test
    void createHeroWarrior() {
        Hero directCreateWarrior = new Warrior();

        assertEquals(directCreateWarrior.getName(), HeroFactory.createHero("Warrior").getName());
    }

    @Test
    void createHeroNinja() {
        Hero directCreateNinja = new Ninja();

        assertEquals(directCreateNinja.getName(), HeroFactory.createHero("Ninja").getName());
    }

    @Test
    void createHeroWizard() {
        Hero directCreateWizard = new Wizard();

        assertEquals(directCreateWizard.getName(), HeroFactory.createHero("Wizard").getName());
    }

    @Test
    void createHeroInvalid() {
        Hero directCreateWarrior = new Warrior();

        assertEquals(directCreateWarrior.getName(), HeroFactory.createHero("Steve").getName());
    }

}