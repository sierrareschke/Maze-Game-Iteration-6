package csci.ooad.polymorphia.command;

import csci.ooad.polymorphia.Food;
import csci.ooad.polymorphia.characters.Character;
import csci.ooad.polymorphia.maze.Room;
import csci.ooad.polymorphia.observer.FightObserver;

public class CommandFactory {
    public static Command createCommand(String command, Character character, Room room) {
        return switch (command) {
            // TODO - arguments for commmands
            case "eat" -> new EatCommand();
            case "move" -> new MoveCommand(character, room);
            case "fight" -> new FightCommand();
            default -> null;
        };
    }
}
