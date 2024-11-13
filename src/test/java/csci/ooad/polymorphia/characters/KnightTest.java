package csci.ooad.polymorphia.characters;

import csci.ooad.polymorphia.maze.Maze;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class KnightTest {
    static final Double INITIAL_KNIGHT_HEATH = 8.0;
    static final Double INITIAL_CREATURE_HEATH = 8.0;

    @Test
    void testFighting() {
        // Arrange - put creature in room with two adventurers
        Double lowHealth = 2.0;
        Character strongMan = CharacterFactory.createKnight("StrongKnight");
        Character weakKnight = CharacterFactory.createKnight("WeakKnight");
        Character creature = CharacterFactory.createCreature("Ogre");
        Maze.getNewBuilder()
                .createRoom("only room")
                .addAdventurers(strongMan)
                .addAdventurers(weakKnight)
                .addCreatures(creature)
                .build();

        // Act - the weak knight should fight
        weakKnight.doAction();

        // Assert – the fight did occur and changed the health of both combatants
        assertNotEquals(lowHealth, weakKnight.getHealth());
        assertNotEquals(INITIAL_CREATURE_HEATH, creature.getHealth());
    }
}
