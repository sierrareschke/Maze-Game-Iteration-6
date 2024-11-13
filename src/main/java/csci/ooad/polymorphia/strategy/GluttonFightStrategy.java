package csci.ooad.polymorphia.strategy;

import csci.ooad.polymorphia.characters.Character;
import csci.ooad.polymorphia.command.Command;
import csci.ooad.polymorphia.command.CommandFactory;
import csci.ooad.polymorphia.maze.Room;

public class GluttonFightStrategy implements FightStrategy {

    @Override
    public Command fight(Character glutton) {
        Room currentRoom = glutton.getCurrentLocation();
        Boolean isDemonPresent = currentRoom.hasDemon();
        Boolean isFoodPresent = currentRoom.hasFood();
        if (isDemonPresent || isFoodPresent) {
            Character creature = currentRoom.getHealthiestCreature();
            return CommandFactory.createFightCommand(glutton, creature);
        } else {
            return CommandFactory.createMoveCommand(glutton);
        }
    }
}
