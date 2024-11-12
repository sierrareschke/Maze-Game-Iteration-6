package csci.ooad.polymorphia.command;

import csci.ooad.polymorphia.Food;
import csci.ooad.polymorphia.observer.FightObserver;

public class CommandFactory {
    public static Command createCommand(String command) {
        return switch (command) {
            case "eat" -> new EatCommand();
            case "move" -> new MoveCommand();
            case "fight" -> new FightCommand();
            default -> null;
        };
    }
}
