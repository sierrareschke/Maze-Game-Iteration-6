package csci.ooad.polymorphia.strategy;

import csci.ooad.polymorphia.command.Command;
import csci.ooad.polymorphia.characters.Character;

public interface MoveStrategy {
    Command move(Character character);
}
