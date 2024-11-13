package csci.ooad.polymorphia.strategy;

import csci.ooad.polymorphia.characters.Character;
import csci.ooad.polymorphia.command.Command;
import csci.ooad.polymorphia.command.CommandFactory;
import csci.ooad.polymorphia.maze.Room;

public class CowardFightStrategy implements FightStrategy {

    private final Character coward;

    public CowardFightStrategy(Character coward) {
        this.coward = coward;
    }

    @Override
    public Command fight() {
        Room currentRoom = coward.getCurrentLocation();
        Boolean cannotMove = currentRoom.getNeighbors().isEmpty();
        Boolean isDemonPresent = currentRoom.hasDemon();
        if (cannotMove || isDemonPresent) {
            Character demon = currentRoom.getDemon();
            return CommandFactory.createFightCommand(coward, demon);
        } else {
            return CommandFactory.createMoveCommand(coward);
        }
    }
}
