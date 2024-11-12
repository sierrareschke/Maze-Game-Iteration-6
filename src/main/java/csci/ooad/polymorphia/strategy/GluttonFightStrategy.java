package csci.ooad.polymorphia.strategy;

import csci.ooad.polymorphia.command.Command;
import csci.ooad.polymorphia.command.CommandFactory;

public class GluttonFightStrategy implements FightStrategy {

    @Override
    public Command fight(){
        return CommandFactory.createCommand("fight");
    }
}
