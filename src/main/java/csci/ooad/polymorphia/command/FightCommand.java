package csci.ooad.polymorphia.command;

import csci.ooad.polymorphia.Die;
import csci.ooad.polymorphia.EventBus;
import csci.ooad.polymorphia.EventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import csci.ooad.polymorphia.characters.Character;

import static csci.ooad.polymorphia.EventBus.post;

public class FightCommand implements Command {
    static final Double HEALTH_LOST_IN_FIGHT_REGARDLESS_OF_OUTCOME = 0.5;
    Character adventurer;
    Character opponent;
    Die dice;
    private static final Logger logger = LoggerFactory.getLogger(FightCommand.class);


    public FightCommand(Character c1, Character c2) {
        this.adventurer = c1;
        this.opponent = c2;
        dice = Die.getInstance();
    }

    @Override
    public void execute() {
        Integer adventurerRoll = Die.rollSixSided();
        Integer creatureRoll = Die.rollSixSided();
        logger.info(adventurer + " is fighting " + opponent);
        logger.info(adventurer + " rolled " + adventurerRoll);
        logger.info(opponent + " rolled " + creatureRoll);

        if (adventurerRoll > creatureRoll) {
            post(EventType.FightOutcome, adventurer.getName() + " won a battle against " + opponent.getName());
            opponent.loseFightDamage(adventurerRoll - creatureRoll);
        } else if (creatureRoll > adventurerRoll) {
            post(EventType.FightOutcome, opponent.getName() + " won a battle against " + adventurer.getName());
            adventurer.loseFightDamage(creatureRoll - adventurerRoll);
        } else {
            post(EventType.FightOutcome, adventurer.getName() + " tied in a battle against " + opponent.getName());
        }

        adventurer.loseHealth(HEALTH_LOST_IN_FIGHT_REGARDLESS_OF_OUTCOME);
        opponent.loseHealth(HEALTH_LOST_IN_FIGHT_REGARDLESS_OF_OUTCOME);
    }


}







