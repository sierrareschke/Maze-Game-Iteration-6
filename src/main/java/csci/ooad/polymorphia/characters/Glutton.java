//package csci.ooad.polymorphia.characters;
//
//public class Glutton extends Adventurer {
//    static final Double INITIAL_HEATH = 3.0;
//
//    public Glutton(String name) {
//        this(name, INITIAL_HEATH);
//    }
//
//    public Glutton(String name, Double initialHealth) {
//        super(name, initialHealth);
//    }
//
//    @Override
//    Boolean shouldFight() {
//        if (!getCurrentLocation().hasDemon() && !getCurrentLocation().hasFood()) {
//            return false;
//        }
//        return super.shouldFight();
//    }
//}
