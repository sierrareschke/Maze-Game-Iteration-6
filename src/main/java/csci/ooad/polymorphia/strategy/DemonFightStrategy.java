package csci.ooad.polymorphia.strategy;

import csci.ooad.polymorphia.characters.Character;
import csci.ooad.polymorphia.maze.Room;

import csci.ooad.polymorphia.command.Command;
import csci.ooad.polymorphia.command.CommandFactory;

public class DemonFightStrategy implements FightStrategy {
    private final Character demon;

    public DemonFightStrategy(Character demon) {
        this.demon = demon;
    }

    @Override
    public Command fight() {
        Character healthiestAdventurer = demon.getCurrentLocation().getHealthiestAdventurer();
        if (healthiestAdventurer != null) {
            return CommandFactory.createFightCommand(demon, healthiestAdventurer);
        } else {
            return CommandFactory.createMoveCommand(demon);
        }
    }
}
