package csci.ooad.polymorphia.strategy;

import csci.ooad.polymorphia.characters.Knight;
import csci.ooad.polymorphia.command.Command;
import csci.ooad.polymorphia.command.CommandFactory;

public class KnightEatStrategy implements EatStrategy {

    @Override
    public Command eat(){
        return CommandFactory.createCommand("eat");
    }
}
