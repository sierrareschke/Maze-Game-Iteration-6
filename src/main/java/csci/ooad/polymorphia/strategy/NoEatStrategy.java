package csci.ooad.polymorphia.strategy;

import csci.ooad.polymorphia.NoFoodException;
import csci.ooad.polymorphia.command.Command;
import csci.ooad.polymorphia.command.CommandFactory;
import csci.ooad.polymorphia.characters.Character;

public class NoEatStrategy implements EatStrategy {

    @Override
    public void eat(Character character) throws NoFoodException {
//        return CommandFactory.createEatCommand(character);
    }
}
