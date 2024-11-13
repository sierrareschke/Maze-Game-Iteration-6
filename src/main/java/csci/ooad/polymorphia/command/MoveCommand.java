package csci.ooad.polymorphia.command;

import csci.ooad.polymorphia.characters.Character;

public class MoveCommand implements Command {
    public MoveCommand(Character character){
        // Initialize the command here
    }

    @Override
    public void execute() {
        // Do something in here
    }
}


/*    protected void move() {
        Room nextLocation = getCurrentLocation().getRandomNeighbor();
        if (nextLocation != null) {
            String message = getName() + " moved from " + getCurrentLocation().getName() + " to " + nextLocation.getName();
            logger.info(message);
            post(EventType.Moved, message);
            nextLocation.enter(this);
            loseHealth(HEALTH_LOST_IN_MOVING_ROOMS);
        } else {
            logger.warn("{} has no neighbors!", getCurrentLocation().getName());
        }
    }*/