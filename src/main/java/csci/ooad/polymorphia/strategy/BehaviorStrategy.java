package csci.ooad.polymorphia.strategy;

import csci.ooad.polymorphia.command.Command;

public interface BehaviorStrategy {
    Command getAction();
}
