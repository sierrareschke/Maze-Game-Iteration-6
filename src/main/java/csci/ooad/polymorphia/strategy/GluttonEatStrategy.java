package csci.ooad.polymorphia.strategy;

import csci.ooad.polymorphia.EventType;
import csci.ooad.polymorphia.Food;
import csci.ooad.polymorphia.NoFoodException;
import csci.ooad.polymorphia.command.Command;
import csci.ooad.polymorphia.command.CommandFactory;
import csci.ooad.polymorphia.characters.Character;
import csci.ooad.polymorphia.maze.Room;

import java.util.List;

import static csci.ooad.polymorphia.EventBus.post;

public class GluttonEatStrategy implements EatStrategy {
    @Override
    public Command eat(Character character) {
        Room room = character.getCurrentLocation();
        List<Food> foodItems = room.getFoodItems();
        if (!foodItems.isEmpty()) {
            return CommandFactory.createEatCommand(character);
        }
        return CommandFactory.createNoCommand();
    }
}


