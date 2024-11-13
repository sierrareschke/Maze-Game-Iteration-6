package csci.ooad.polymorphia.strategy;

import csci.ooad.polymorphia.characters.Character;
import csci.ooad.polymorphia.command.Command;
import csci.ooad.polymorphia.command.CommandFactory;
import csci.ooad.polymorphia.maze.Room;

public class KnightFightStrategy implements FightStrategy {

    private final Character knight;

    public KnightFightStrategy(Character knight) {
        this.knight = knight;
    }

    @Override
    public Command fight() {
        Room currentRoom = knight.getCurrentLocation();
        Boolean isCreaturePresent = currentRoom.hasLivingCreatures();
        if (isCreaturePresent) {
            Character creature = currentRoom.getHealthiestCreature();
            return CommandFactory.createFightCommand(knight, creature);
        } else {
            return CommandFactory.createMoveCommand(knight);
        }
    }
}

