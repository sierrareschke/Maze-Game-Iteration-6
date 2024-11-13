package csci.ooad.polymorphia.characters;

import csci.ooad.polymorphia.Die;
import csci.ooad.polymorphia.EventBus;
import csci.ooad.polymorphia.EventType;
import csci.ooad.polymorphia.command.Command;
import csci.ooad.polymorphia.maze.Room;
import csci.ooad.polymorphia.strategy.EatStrategy;
import csci.ooad.polymorphia.strategy.FightStrategy;
import csci.ooad.polymorphia.strategy.MoveStrategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;

import static csci.ooad.polymorphia.EventBus.post;


public class Character implements Comparable<Character> {
    static final Double DEFAULT_INITIAL_HEALTH = 5.0;
    static final Double HEALTH_LOST_IN_FIGHT_REGARDLESS_OF_OUTCOME = 0.5;
    static final Double HEALTH_LOST_IN_MOVING_ROOMS = 0.25;
    private static final Logger logger = LoggerFactory.getLogger(Character.class);
    private static final DecimalFormat formatter = new DecimalFormat("0.0");
    protected String name;
    private Double health;
    private CharacterType type;

    private Room currentLocation;


    ///////////////////////////////  new section:

    private static FightStrategy fightStrategy;
    private static EatStrategy eatStrategy;
    private static MoveStrategy moveStrategy;


    ///////////////////////////////  new section:
    protected String name;
    private Double health;
    private Room currentLocation;

    public Character(String name, Double initialHealth, FightStrategy fightStrategy, EatStrategy eatStrategy, MoveStrategy moveStrategy,CharacterType type) {
        this.name = name;
        this.health = initialHealth;
        this.fightStrategy = fightStrategy;
        this.eatStrategy = eatStrategy;
        this.moveStrategy = moveStrategy;
        this.type = type;
    }

    public Character(String name) {
        this(name, DEFAULT_INITIAL_HEALTH);
    }

    public Character(String name, Double initialHealth) {
        this.name = name;
        this.health = initialHealth;
    }

    public static EatStrategy getEatStrategy() {
        return eatStrategy;
    }


    //////////////////////////////

    public static FightStrategy getFightStrategy() {
        return fightStrategy;
    }

    public static MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }

    public Room getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public int compareTo(Character otherCharacter) {
        return getHealth().compareTo(otherCharacter.getHealth());
    }

    public void enterRoom(Room room) {
        this.currentLocation = room;
    }

    @Override
    public String toString() {
        return getName() + "(health: " + formatter.format(getHealth()) + ")";
    }

    public void loseHealth(Double healthPoints) {
        if (health <= 0) {
            return;     // already dead, probably called for mandatory health loss for having a fight
        }

        health -= healthPoints;

        String lostHealthDescription = this.getName() + " just lost " + healthPoints + " points";
        EventBus.getInstance().postMessage(EventType.LostHealth, lostHealthDescription);

        if (health <= 0) {
            String eventDescription = this.getName() + " just died!";
            logger.info(eventDescription);
            EventBus.getInstance().postMessage(EventType.Death, eventDescription);
        }
    }

    public Double getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public Boolean isAlive() {
        return getHealth() > 0;
    }

    public void loseFightDamage(double fightDamage) {
        loseHealth(fightDamage);
    }

    protected boolean cannotMove() {
        return getCurrentLocation().getNeighbors().isEmpty();
    }

    public Boolean isAdventurer() {
        return type == CharacterType.Adventurer;
    }
    public Boolean isCreature() {
        return type == CharacterType.Creature;
    }
    public Boolean isDemon() {
        return type == CharacterType.Demon;
    }
    public Boolean isCoward() {
        return type == CharacterType.Coward;
    }
    public Boolean isKnight() {
        return type == CharacterType.Knight;
    }
    public Boolean isGlutton() {
        return type == CharacterType.Glutton;
    }



    public void doAction() {
        // Do nothing by default
    }

//    protected void move() {
//        Room nextLocation = getCurrentLocation().getRandomNeighbor();
//        if (nextLocation != null) {
//            String message = getName() + " moved from " + getCurrentLocation().getName() + " to " + nextLocation.getName();
//            logger.info(message);
//            post(EventType.Moved, message);
//            nextLocation.enter(this);
//            loseHealth(HEALTH_LOST_IN_MOVING_ROOMS);
//        } else {
//            logger.warn("{} has no neighbors!", getCurrentLocation().getName());
//        }
//    }


    public void gainHealth(double healthValue) {
        this.health += healthValue;
        logger.info("{} gained health: {}", getName(), formatter.format(getHealth()));
    }


}
