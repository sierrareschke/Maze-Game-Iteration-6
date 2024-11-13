package csci.ooad.polymorphia.command;

import csci.ooad.polymorphia.Food;
import csci.ooad.polymorphia.NoFoodException;
import csci.ooad.polymorphia.characters.Character;


public class EatCommand implements Command {
    private Character character;
    // TODO - pass room or food item to EatCommand ?

    public EatCommand(Character character) {
        this.character = character;
    }

    @Override
    public void execute() throws NoFoodException {
        character.getEatStrategy().eat(character);
    }
}
