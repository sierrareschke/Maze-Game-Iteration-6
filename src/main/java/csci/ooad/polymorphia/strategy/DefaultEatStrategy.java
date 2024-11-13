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
    public Command eat(Character character) throws NoFoodException {
        Room room = character.getCurrentLocation();
        List<Food> foodItems = room.getFoodItems();
        if (!foodItems.isEmpty()) {
            Food foodItem = room.removeFoodItem();
            character.gainHealth(foodItem.getHealthValue());
            String message = character.getName() + " just ate " + foodItem.getName();
            // logger ??
            //logger.info(message);
            post(EventType.AteSomething, message);
        }
        return CommandFactory.createEatCommand(character);
    }
}
