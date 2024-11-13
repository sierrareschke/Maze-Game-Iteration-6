package csci.ooad.polymorphia.strategy;

import csci.ooad.polymorphia.NoFoodException;
import csci.ooad.polymorphia.command.Command;
import csci.ooad.polymorphia.command.CommandFactory;
import csci.ooad.polymorphia.characters.Character;

public class DemonEatStrategy implements EatStrategy {

    @Override
    public Command eat(Character demon) throws NoFoodException {
        // Demon doesn't eat, it just fights
        Character healthiestAdventurer = demon.getCurrentLocation().getHealthiestAdventurer();
        if (healthiestAdventurer != null) {
            return CommandFactory.createFightCommand(demon, healthiestAdventurer);
        } else {
            return CommandFactory.createMoveCommand(demon);
        }
    }
}
