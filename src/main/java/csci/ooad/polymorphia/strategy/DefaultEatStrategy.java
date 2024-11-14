package csci.ooad.polymorphia.strategy;

import csci.ooad.polymorphia.EventType;
import csci.ooad.polymorphia.Food;
import csci.ooad.polymorphia.NoFoodException;
import csci.ooad.polymorphia.command.Command;
import csci.ooad.polymorphia.command.CommandFactory;
import csci.ooad.polymorphia.maze.Room;
import csci.ooad.polymorphia.characters.Character;


import java.util.List;

import static csci.ooad.polymorphia.EventBus.post;

public class DefaultEatStrategy implements EatStrategy {

    @Override
    public Command eat(Character character) {
        Room room = character.getCurrentLocation();
        List<Food> foodItems = room.getFoodItems();
        // if there is food, the character will eat
        if (!foodItems.isEmpty()) {
            Food foodItem = room.removeFoodItem();
            return CommandFactory.createEatCommand(character);
        }
        else{ // if there is not food, the character will move
            return CommandFactory.createMoveCommand(character);
        }
    }
}
