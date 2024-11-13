package csci.ooad.polymorphia.strategy;

import csci.ooad.polymorphia.command.Command;
import csci.ooad.polymorphia.command.CommandFactory;

public class NoEatStrategy implements EatStrategy {

    @Override
    public Command eat(){
        return CommandFactory.createCommand("eat");
    }
}
