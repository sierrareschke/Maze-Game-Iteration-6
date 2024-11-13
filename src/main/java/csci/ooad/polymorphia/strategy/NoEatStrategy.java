package csci.ooad.polymorphia.strategy;

import csci.ooad.polymorphia.NoFoodException;
import csci.ooad.polymorphia.characters.Character;
import csci.ooad.polymorphia.command.Command;
import csci.ooad.polymorphia.command.CommandFactory;

public class NoEatStrategy implements EatStrategy {
    Character character;
    public NoEatStrategy(Character character) {
        this.character = character;
    }

    @Override
    public Command eat(Character character) {
        return CommandFactory.createNoCommand();
    }
}
