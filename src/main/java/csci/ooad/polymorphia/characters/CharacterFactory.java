package csci.ooad.polymorphia.characters;

import csci.ooad.polymorphia.strategy.*;


import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class CharacterFactory {
    public static String[] ADVENTURER_NAMES = new String[]{"Frodo", "Arwen", "Nikhil", "Sierra", "Matt", "Fran"};
    public static String[] KNIGHT_NAMES = new String[]{"Sir Lancelot", "Lady Brienne", "King Arthur", "Sir Jamey", "Aragorn", "Isildur"};
    public static String[] COWARD_NAMES = new String[]{"Sir Robin", "Sir Scaredy Cat", "Lady Faints-a-lot", "Lady Runaway", "Sir Chicken", "Lady Hides-a-lot"};
    public static String[] GLUTTON_NAMES = new String[]{"Sir Eats-a-lot", "Sir Gobbles", "Lady Munches", "Lady Snacks", "Sir Nibbles", "Lady Noshes"};
    public static String[] CREATURE_NAMES = new String[]{"Dragon", "Ogre", "Orc", "Shelob", "Troll", "Evil Wizard"};
    public static String[] DEMON_NAMES = new String[]{"Satan", "Beelzebub", "Devil", "Incubus", "Lucifer", "Succubus"};

    Random random = new Random();

    public List<Adventurer> createNumberOfAdventurers(Integer numAdventurers) {
        return IntStream.range(0, numAdventurers)
                .mapToObj(i -> new Adventurer(ADVENTURER_NAMES[i % ADVENTURER_NAMES.length]))
                .map(Adventurer.class::cast)
                .toList();
    }

    public List<Creature> createNumberOfCreatures(Integer numCreatures) {
        return IntStream.range(0, numCreatures)
                .mapToObj(i -> new Creature(CREATURE_NAMES[i % CREATURE_NAMES.length]))
                .map(Creature.class::cast)
                .toList();
    }

    public List<Creature> createNumberOfDemons(Integer numDemons) {
        return IntStream.range(0, numDemons)
                .mapToObj(i -> new Demon(DEMON_NAMES[i % DEMON_NAMES.length]))
                .map(Creature.class::cast)
                .toList();
    }

    public List<Adventurer> createNumberOfKnights(Integer numAdventurers) {
        return IntStream.range(0, numAdventurers)
                .mapToObj(i -> new Knight(KNIGHT_NAMES[random.nextInt(KNIGHT_NAMES.length)]))
                .map(Adventurer.class::cast)
                .toList();
    }

    public List<Adventurer> createNumberOfCowards(Integer numAdventurers) {
        return IntStream.range(0, numAdventurers)
                .mapToObj(i -> new Coward(COWARD_NAMES[random.nextInt(COWARD_NAMES.length)]))
                .map(Adventurer.class::cast)
                .toList();
    }

    public List<Adventurer> createNumberOfGluttons(Integer numAdventurers) {
        return IntStream.range(0, numAdventurers)
                .mapToObj(i -> new Glutton(GLUTTON_NAMES[random.nextInt(GLUTTON_NAMES.length)]))
                .map(Adventurer.class::cast)
                .toList();
    }



    //////////////////////////////////////////// new below
    static final Double DEFAULT_INITIAL_HEALTH = 5.0;
    static final Double CREATURE_INITIAL_HEALTH = 3.0;
    static final Double DEMON_INITIAL_HEALTH = 15.0;



    public Character createAdventurer(String name) {
        return new Character(name, DEFAULT_INITIAL_HEALTH, new AdventurerFightStrategy(), new DefaultEatStrategy(), new DefaultMoveStrategy(),CharacterType.Adventurer);
    }

    public Character createKnight(String name) {
        return new Character(name, DEFAULT_INITIAL_HEALTH, new KnightFightStrategy(), new DefaultEatStrategy(), new DefaultMoveStrategy(),CharacterType.Knight);
    }

    public Character createGlutton(String name) {
        return new Character(name, DEFAULT_INITIAL_HEALTH, new GluttonFightStrategy(), new GluttonEatStrategy(), new DefaultMoveStrategy(),CharacterType.Glutton);
    }

    public Character createCoward(String name) {
        return new Character(name, DEFAULT_INITIAL_HEALTH, new CowardFightStrategy(), new DefaultEatStrategy(), new DefaultMoveStrategy(),CharacterType.Coward);
    }

    public Character createDemon(String name) {
        return new Character(name, DEMON_INITIAL_HEALTH, new DemonFightStrategy(), new NoEatStrategy(), new DefaultMoveStrategy(),CharacterType.Demon);
    }

    public Character createCreature(String name) {
        return new Character(name, CREATURE_INITIAL_HEALTH, new CreatureFightStrategy(), new NoEatStrategy(), new DefaultMoveStrategy(),CharacterType.Creature);
        //return new Character(name, character -> new NoOpCommand()); // "Do nothing" for non-Demon creatures
    }



}
