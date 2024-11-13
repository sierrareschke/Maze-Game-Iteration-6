package csci.ooad.polymorphia.command;

import csci.ooad.polymorphia.NoFoodException;

public interface Command {
    void execute() throws NoFoodException;
}
