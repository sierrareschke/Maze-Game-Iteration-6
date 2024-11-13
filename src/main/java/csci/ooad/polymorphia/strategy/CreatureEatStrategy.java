package csci.ooad.polymorphia.strategy;

import csci.ooad.polymorphia.NoFoodException;
import csci.ooad.polymorphia.characters.Character;
import csci.ooad.polymorphia.command.Command;
import csci.ooad.polymorphia.command.CommandFactory;

public class CreatureEatStrategy implements EatStrategy {

    @Override
    public Command eat(Character character) throws NoFoodException {
        // TODO - creatures should do nothing ??
        // TODO - do we need a DoNothing strategy ??
        return CommandFactory.createEatCommand(character);
    }
}
