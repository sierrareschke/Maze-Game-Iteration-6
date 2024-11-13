package csci.ooad.polymorphia.command;

import csci.ooad.polymorphia.Food;
import csci.ooad.polymorphia.characters.Character;
import csci.ooad.polymorphia.observer.FightObserver;
import csci.ooad.polymorphia.characters.Character;

public class CommandFactory {

    public Command createMoveCommand(Character character, Room targetRoom) {
        return character.getMoveStrategy().getMoveCommand(character, targetRoom);
    }

    public static Command createMoveCommand(Character character) {
        return new MoveCommand(character);
    }

    public Command createEatCommand(Character character) {
        return character.getEatStrategy().getEatCommand(character);
    }

    public static Command createEatCommand(Character character, Food foodItem) {
        return new EatCommand(character, foodItem);
    }

    public Command createFightCommand(Character character, Character opponent) {
        return character.getFightStrategy().fight(character, opponent);

    public static Command createFightCommand(Character c1, Character c2) {
        return new FightCommand(c1, c2);
    }



}
