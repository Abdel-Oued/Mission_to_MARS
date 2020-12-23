package fr.ensta.missiontomars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Nested
@DisplayName("When a Rocket has been created")
class RocketTest {
    private final Rocket rocket = new Rocket(10, 18, 100);

    @Test
    @DisplayName("test if the rocket can carry")
    void canCarryTest() {
        assertTrue(rocket.canCarry(new Item(4)));
    }

    @Test
    @DisplayName("test if the rocket can not carry")
    void canCarryFailedTest() {
        assertTrue(!(rocket.canCarry(new Item(25))));
    }

    @Test
    @DisplayName("test if the item is carried")
    void carrySuccesTest() {
        rocket.carry(new Item(5));
        assertEquals(15, rocket.currentWeight);

    }

    @Test
    @DisplayName("test if the item is not carried")
    void carryFailedTest() {
        rocket.carry(new Item(9));
        assertNotEquals(19, rocket.currentWeight);
        assertTrue(rocket.currentWeight <= rocket.maxWeight);

    }
}