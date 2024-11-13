package csci.ooad.polymorphia.command;

import csci.ooad.polymorphia.EventType;
import csci.ooad.polymorphia.Food;
import csci.ooad.polymorphia.NoFoodException;
import csci.ooad.polymorphia.characters.Character;
import csci.ooad.polymorphia.maze.Room;

import static csci.ooad.polymorphia.EventBus.post;


public class NoCommand implements Command {

    @Override
    public void execute() {
        // Do nothing
    }
}
