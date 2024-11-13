//package csci.ooad.polymorphia.characters;
//
//public class Coward extends Adventurer {
//    public Coward(String name) {
//        super(name);
//    }
//
//    public Coward(String name, Double initialHealth) {
//        super(name, initialHealth);
//    }
//
//    @Override
//    Boolean shouldFight() {
//        // Coward should fight if it cannot move or if there is a Demon in the room
//        return cannotMove() || getCurrentLocation().hasDemon();
//    }
//
//    @Override
//    public Boolean isCoward() {
//        return true;
//    }
//
//
//    @Override
//    public void move() {
//        if (getCurrentLocation().hasLivingCreatures()) {
//            loseHealth(0.25);
//        }
//        super.move();
//    }
//}
