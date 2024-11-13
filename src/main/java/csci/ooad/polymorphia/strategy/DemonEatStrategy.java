package csci.ooad.polymorphia.strategy;

import csci.ooad.polymorphia.NoFoodException;
import csci.ooad.polymorphia.command.Command;
import csci.ooad.polymorphia.command.CommandFactory;
import csci.ooad.polymorphia.characters.Character;

public class DemonEatStrategy implements EatStrategy {

    @Override
    public Command eat(Character character) throws NoFoodException {
        // Demon doesn't eat, it just fights
        return CommandFactory.createFightCommand(character);
    }
}
