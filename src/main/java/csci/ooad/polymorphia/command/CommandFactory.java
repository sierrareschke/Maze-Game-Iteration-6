package csci.ooad.polymorphia.command;

import csci.ooad.polymorphia.Food;
import csci.ooad.polymorphia.NoFoodException;
import csci.ooad.polymorphia.characters.Character;
import csci.ooad.polymorphia.maze.Room;
import csci.ooad.polymorphia.observer.FightObserver;
import csci.ooad.polymorphia.characters.Character;

public class CommandFactory {

    public Command createMoveCommand(Character character, Room targetRoom) {
        return character.getMoveStrategy().move(character);
    }

    // Note: add another move command method if need target room passed in

    public Command createEatCommand(Character character) throws NoFoodException {
        return character.getEatStrategy().eat(character);
    }


    public Command createFightCommand(Character character, Character opponent) {
        return character.getFightStrategy().fight(character);
    }




}
