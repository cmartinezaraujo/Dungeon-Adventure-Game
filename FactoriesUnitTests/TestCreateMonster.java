package FactoriesUnitTests;

import org.junit.jupiter.api.Test;

import Factories.Gremlin;
import Factories.Monster;
import Factories.MonsterFactory;
import Factories.Ogre;
import Factories.Skeleton;

import static org.junit.jupiter.api.Assertions.*;

class TestCreateMonster {

    @Test
    void createMonsterOgre() {

        Monster directCreateOgre = new Ogre();

        assertEquals(directCreateOgre.getName(), MonsterFactory.createMonster("ogre").getName());
    }

    @Test
    void createMonsterSkeleton() {

        Monster directCreateSkeleton = new Skeleton();

        assertEquals(directCreateSkeleton.getName(), MonsterFactory.createMonster("skeleton").getName());
    }
    @Test
    void createMonsterGremlin() {

        Monster directCreateGremlin = new Gremlin();

        assertEquals(directCreateGremlin.getName(), MonsterFactory.createMonster("gremlin").getName());
    }

    @Test
    void createMonsterInvalid() {

        Monster directCreateGremlin = new Gremlin();

        // if invalid monster name is given should return a gremlin by default

        assertEquals(directCreateGremlin.getName(), MonsterFactory.createMonster("jeff").getName());
    }

}