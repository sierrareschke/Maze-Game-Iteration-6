package csci.ooad.polymorphia.characters;

import csci.ooad.polymorphia.maze.Maze;
import csci.ooad.polymorphia.NoSuchRoomException;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.OptionalLong;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CowardTest {
    @Test
    void testRunning() throws NoSuchRoomException {
        // Arrange - put creature in room with two adventurers
        Double initialHealth = 5.0;
        Character coward = CharacterFactory.createCoward("Coward", Optional.of(initialHealth));
        Character dragon = CharacterFactory.createCreature("Dragon", Optional.empty());
        Maze twoRoomMaze = Maze.getNewBuilder()
                .createFullyConnectedRooms("initial", "final")
                .addToRoom("initial", coward)
                .addToRoom("initial", dragon)
                .build();

        // Act - the weak knight should fight
        coward.doAction();

        // Assert – the coward ran to the other room and lost some health doing it
        // since there was a creature in the room.
        assertTrue(twoRoomMaze.getRoom("final").hasLivingAdventurers());
        assertTrue(coward.getHealth() < initialHealth);
    }

    @Test
    void testFighting() {
        // Arrange - put creature in room with two adventurers
        Character coward = CharacterFactory.createCoward("Coward", Optional.empty());
        Character satan = CharacterFactory.createDemon("Demon");
        Double satanInitialHealth = satan.getHealth();
        Maze.getNewBuilder()
                .createFullyConnectedRooms("initial", "final")
                .addToRoom("initial", coward)
                .addToRoom("initial", satan)
                .build();

        // Act - the coward must fight a Demon
        coward.doAction();

        // Assert – the coward ran to the other room
        assertNotEquals(satanInitialHealth, satan.getHealth());
    }
}
