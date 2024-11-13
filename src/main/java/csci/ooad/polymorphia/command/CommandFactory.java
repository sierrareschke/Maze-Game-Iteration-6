package csci.ooad.polymorphia.command;

import csci.ooad.polymorphia.Food;
import csci.ooad.polymorphia.NoFoodException;
import csci.ooad.polymorphia.characters.Character;

public class CommandFactory {

    public static Command createMoveCommand(Character character) {
        return character.getMoveStrategy().move(character);
    }

    // Note: add another move command method if need target room passed in

    public static Command createEatCommand(Character character, Food foodItem) throws NoFoodException {
        return null;
    }


    public static Command createFightCommand(Character character, Character opponent) {
        return new FightCommand(character, opponent);
    }




}
