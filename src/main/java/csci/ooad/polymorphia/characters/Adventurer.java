package csci.ooad.polymorphia.characters;

import csci.ooad.polymorphia.EventType;
import csci.ooad.polymorphia.Food;
import csci.ooad.polymorphia.NoFoodException;
import csci.ooad.polymorphia.maze.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static csci.ooad.polymorphia.EventBus.post;

//
//public class Adventurer extends Character {
//    private static final Logger logger = LoggerFactory.getLogger(Adventurer.class);
//
//    public Adventurer(String name) {
//        super(name);
//    }
//
//    public Adventurer(String name, Double initialHealth) {
//        super(name, initialHealth);
//    }
//
//    public void enterRoom(Room room) {
//        if (getCurrentLocation() != null) {
//            if (getCurrentLocation().equals(room)) {
//                return;
//            }
//            getCurrentLocation().remove(this);
//        }
//        super.enterRoom(room);
//    }
//
//    public void doAction() {
//        if (getCurrentLocation().hasDemon()) {
//            fight(getCurrentLocation().getDemon());
//            return;
//        }
//
//        if (getCurrentLocation().hasLivingCreatures() && shouldFight()) {
//            fight(getCurrentLocation().getHealthiestCreature());
//            return;
//        }
//
//        if (getCurrentLocation().hasFood()) {
//            try {
//                eatFood();
//            } catch (NoFoodException e) {
//                logger.error("No food in room");
//            }
//        } else {
//            move();
//        }
//    }
//
//    private void eatFood() throws NoFoodException {
//        Food foodItem = getCurrentLocation().removeFoodItem();
//        this.gainHealth(foodItem.getHealthValue());
//        String message = this.getName() + " just ate " + foodItem.getName();
//        logger.info(message);
//        post(EventType.AteSomething, message);
//    }
//
//    Boolean shouldFight() {
//        return creatureInRoomWithMe() && iAmHealthiestInRoom();
//    }
//
//    private boolean iAmHealthiestInRoom() {
//        return this.equals(getCurrentLocation().getHealthiestAdventurer());
//    }
//
//    Boolean creatureInRoomWithMe() {
//        return getCurrentLocation().hasLivingCreatures();
//    }
//
//    @Override
//    public Boolean isAdventurer() {
//        return true;
//    }
//
//}