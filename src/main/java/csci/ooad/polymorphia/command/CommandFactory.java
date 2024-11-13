package csci.ooad.polymorphia.command;

import csci.ooad.polymorphia.Food;
import csci.ooad.polymorphia.characters.Character;
import csci.ooad.polymorphia.observer.FightObserver;

public class CommandFactory {

    public static Command createFightCommand(Character c1, Character c2) {
        return new FightCommand(c1, c2);
    }

    public static Command createMoveCommand(Character character) {
        return new MoveCommand(character);
    }

    public static Command createEatCommand(Character character, Food foodItem) {
        return new EatCommand(character, foodItem);
    }
}
