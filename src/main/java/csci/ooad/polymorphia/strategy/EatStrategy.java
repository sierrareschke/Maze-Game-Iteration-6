package csci.ooad.polymorphia.strategy;

import csci.ooad.polymorphia.NoFoodException;
import csci.ooad.polymorphia.command.Command;
import csci.ooad.polymorphia.characters.Character;

public interface EatStrategy {
    void eat(Character character) throws NoFoodException;
}
