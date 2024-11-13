package csci.ooad.polymorphia.command;

import csci.ooad.polymorphia.Food;
import csci.ooad.polymorphia.observer.FightObserver;
import csci.ooad.polymorphia.characters.Character;

public class CommandFactory {
    //    public static Command createCommand(String command) {
//        return switch (command) {
//            // TODO - arguments for commmands
//            case "eat" -> new EatCommand();
//            case "move" -> new MoveCommand();
//            case "fight" -> new FightCommand();
//            default -> null;
//        };
//    }
    public Command createMoveCommand(Character character, Room targetRoom) {
        return character.getMoveStrategy().getMoveCommand(character, targetRoom);
    }

    public Command createEatCommand(Character character) {
        return character.getEatStrategy().getEatCommand(character);
    }

    public Command createFightCommand(Character character, Character opponent) {
        return character.getFightStrategy().getFightCommand(character, opponent);
    }
}
