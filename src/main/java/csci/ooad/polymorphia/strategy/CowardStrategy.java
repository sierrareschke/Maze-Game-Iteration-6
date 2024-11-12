package csci.ooad.polymorphia.strategy;

import csci.ooad.polymorphia.command.Command;
import csci.ooad.polymorphia.command.CommandFactory;

public class CowardStrategy implements BehaviorStrategy {

    @Override
    public Command getAction(){
        return CommandFactory.createCommand("eat");
    }
}
