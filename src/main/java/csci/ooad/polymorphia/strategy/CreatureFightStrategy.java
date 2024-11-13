package csci.ooad.polymorphia.strategy;

import csci.ooad.polymorphia.command.Command;
import csci.ooad.polymorphia.command.CommandFactory;

public class CreatureFightStrategy implements FightStrategy {

    @Override
    public Command fight(){
        // TODO - creature does not fight
        return CommandFactory.createCommand("fight");
    }
}
