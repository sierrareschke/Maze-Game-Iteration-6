package csci.ooad.polymorphia.command;

import csci.ooad.polymorphia.Food;

public class EatCommand implements Command {
    private Character character;
    private Food foodItem;

    public EatCommand(Character character, Food foodItem) {
        this.character = character;
        this.foodItem = foodItem;
    }

    @Override
    public void execute() {
        character.getEatStrategy().eat(character, foodItem);
    }
}
