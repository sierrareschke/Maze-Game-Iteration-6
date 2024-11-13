package csci.ooad.polymorphia.strategy;

import csci.ooad.polymorphia.characters.Character;
import csci.ooad.polymorphia.maze.Room;

import csci.ooad.polymorphia.command.Command;
import csci.ooad.polymorphia.command.CommandFactory;

public class DemonFightStrategy implements FightStrategy {

    @Override
    public Command fight(Character demon) {
        Character healthiestAdventurer = demon.getCurrentLocation().getHealthiestAdventurer();
        if (healthiestAdventurer != null) {
            return CommandFactory.createFightCommand(demon, healthiestAdventurer);
        } else {
            return CommandFactory.createMoveCommand(demon);
        }
    }
}
