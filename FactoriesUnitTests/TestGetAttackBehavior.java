package FactoriesUnitTests;

import org.junit.jupiter.api.Test;

import Factories.AttackBehavior;
import Factories.AttackFactory;

import static org.junit.jupiter.api.Assertions.*;

class TestGetAttackBehavior {

    @Test
    void getAttackBehaviorDifferentCase() {

        // it shouldn't matter what case the attack name is passed in.
        // the map key will always be the uppercase version of the name

        assertEquals(AttackFactory.getAttackBehavior("crushingblow"), AttackFactory.getAttackBehavior("CrushingBLOW"));
    }

    @Test
    void getAttackBehaviorCrushingBlow() {

        AttackBehavior createCrushingBlow = AttackFactory.getAttackBehavior("CrushingBlow");

        // the 2 objects should be the same exact object with the same address

        assertEquals(createCrushingBlow, AttackFactory.getAttackBehavior("CrushingBlow"));
    }

    @Test
    void getAttackBehaviorNormal() {

        AttackBehavior createNormal = AttackFactory.getAttackBehavior("Normal");

        // the 2 objects should be the same exact object with the same address

        assertEquals(createNormal, AttackFactory.getAttackBehavior("Normal"));
    }

    @Test
    void getAttackBehaviorSurprise() {

        AttackBehavior createSurprise = AttackFactory.getAttackBehavior("Surprise");

        // the 2 objects should be the same exact object with the same address

        assertEquals(createSurprise, AttackFactory.getAttackBehavior("Surprise"));
    }

    @Test
    void getAttackBehaviorInvalid() {

        assertThrows(IllegalArgumentException.class, () -> {
            AttackFactory.getAttackBehavior("invalid");
        });
    }
}