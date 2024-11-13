package csci.ooad.polymorphia;

import csci.ooad.polymorphia.characters.Character;
import csci.ooad.polymorphia.characters.CharacterFactory;
import csci.ooad.polymorphia.maze.Room;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void getRandomNeighbor() {
        Room room = new Room("mainRoom");
        Room neighbor = new Room("neighbor");
        room.connect(neighbor);

        assertEquals(room.getRandomNeighbor(), neighbor);
    }

    @Test
    void testGetRandomNeighborOnRoomWithNoNeighbors() {
        Room room = new Room("onlyRoom");
        assertNull(room.getRandomNeighbor());
    }

    @Test
    void testToString() {
        Room room = new Room("onlyRoom");
        Character frodo = CharacterFactory.createAdventurer("Frodo", Optional.empty());
        room.add(frodo);
        Character ogre = CharacterFactory.createCreature("Ogre", Optional.empty());
        room.add(ogre);

        assertTrue(room.toString().contains("onlyRoom"));
        assertTrue(room.toString().contains("Frodo"));
        assertTrue(room.toString().contains("Ogre"));
    }

    @Test
    void testGetHealthiestAdventurer() {
        // Arrange
        double highestHealth = 5.0;
        double lowestHealth = 3.0;

        Room room = new Room("onlyRoom");
        Character bilbo = CharacterFactory.createAdventurer("Bilbo", Optional.of(highestHealth));
        room.add(bilbo);
        Character frodo = CharacterFactory.createAdventurer("Frodo", Optional.of(lowestHealth));
        room.add(frodo);
        Character troll = CharacterFactory.createCreature("Troll", Optional.of(highestHealth));
        room.add(troll);
        Character orc = CharacterFactory.createCreature("Orc", Optional.of(lowestHealth));
        room.add(orc);

        // Act
        Character fittestAdventurer = room.getHealthiestAdventurer();
        Character fittestCreature = room.getHealthiestCreature();

        // Assert
        assertEquals(bilbo, fittestAdventurer);
        assertEquals(troll, fittestCreature);
    }

    @Test
    void testHealthiestEatsFood() {
        // Arrange
        double highestHealth = 5;
        double lowestHealth = 3;

        Room room = new Room("onlyRoom");
        Character bilbo = CharacterFactory.createAdventurer("Bilbo", Optional.of(highestHealth));
        room.add(bilbo);
        Character frodo = CharacterFactory.createAdventurer("Frodo", Optional.of(lowestHealth));
        room.add(frodo);
        room.add(new Food("burger"));

        // Act
        bilbo.doAction();

        // Assert
        assertEquals(bilbo.getHealth(), highestHealth + Food.DEFAULT_FOOD_HEALTH_VALUE);
    }

    @Test
    void testEatNonExistentFood() {
        // Arrange
        Room room = new Room("onlyRoom");
        assertThrows(NoFoodException.class, room::removeFoodItem);
    }
}