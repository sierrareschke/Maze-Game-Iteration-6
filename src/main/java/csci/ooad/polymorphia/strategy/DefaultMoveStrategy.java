package csci.ooad.polymorphia.strategy;

import csci.ooad.polymorphia.command.Command;
import csci.ooad.polymorphia.command.CommandFactory;

public class DefaultMoveStrategy implements MoveStrategy {

    @Override
    public Command move(){
        return CommandFactory.createCommand("move");
    }
}
