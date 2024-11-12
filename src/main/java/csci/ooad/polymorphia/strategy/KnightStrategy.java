package csci.ooad.polymorphia.strategy;

import csci.ooad.polymorphia.characters.Knight;
import csci.ooad.polymorphia.command.Command;
import csci.ooad.polymorphia.command.CommandFactory;

public class KnightStrategy implements BehaviorStrategy {

    @Override
    public Command getAction(){
        return CommandFactory.createCommand("eat");
    }
}
