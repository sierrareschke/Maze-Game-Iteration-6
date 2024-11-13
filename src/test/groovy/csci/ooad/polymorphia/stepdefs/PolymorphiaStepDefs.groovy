package csci.ooad.polymorphia.stepdefs

import csci.ooad.polymorphia.EventType
import csci.ooad.polymorphia.characters.Adventurer

import csci.ooad.polymorphia.observer.AteFoodObserver
import csci.ooad.polymorphia.observer.DeathObserver
import csci.ooad.polymorphia.observer.FightObserver
import csci.ooad.polymorphia.observer.GameOverObserver
import csci.ooad.polymorphia.observer.LostHealthObserver
import csci.ooad.polymorphia.observer.MovedObserver
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

import static org.junit.jupiter.api.Assertions.*;

class PolymorphiaStepDefs {

    World world
    FightObserver fightObserver = new FightObserver()
    LostHealthObserver lostHealthObserver = new LostHealthObserver()
    AteFoodObserver ateFoodObserver = new AteFoodObserver()
    MovedObserver moveObserver = new MovedObserver();
    DeathObserver deathObserver = new DeathObserver();
    GameOverObserver gameOverObserver = new GameOverObserver()


    PolymorphiaStepDefs(World aWorld) {
        world = aWorld
        world.polymorphia.attach(fightObserver, EventType.FightOutcome)
        world.polymorphia.attach(lostHealthObserver,EventType.LostHealth)
        world.polymorphia.attach(ateFoodObserver,EventType.AteSomething)
        world.polymorphia.attach(moveObserver,EventType.Moved)
        world.polymorphia.attach(deathObserver,EventType.Death)
        world.polymorphia.attach(gameOverObserver,EventType.GameOver)
    }


    @When("I play the game in the created maze")
    void iPlayTheGame() {
        world.polymorphia.play();
    }

    @When("a turn of gameplay takes place")
    void playTurn() {
        world.polymorphia.playTurn()
    }

    @When("adventurer {string} executes his turn")
    public void adventurerExecutesHisTurn(String adventurerName) {
        List<Adventurer> adventurers = world.polymorphia.getLivingAdventurers();
        Adventurer specifiedAdventurer = adventurers.find { it.name == adventurerName }

        if (specifiedAdventurer) {
            specifiedAdventurer.doAction()
        }
    }

    @When("I play the game until all adventurers or all creatures have died")
    public void iPlayTheGameUntilAllAdventurersOrAllCreaturesHaveDied() {
        // play the game until over
        while (!world.polymorphia.isOver()) {
            world.polymorphia.playTurn();
        }

    }

    @Then(/the maze observer is notified of at least {int} death events/)
    public void theMazeObserverIsNotifiedOfTheCorrectNumberOfDeathEvents(int expectedDeaths) {
        // Assert that the observer recorded the expected number of death events
        assertTrue(deathObserver.numDeaths >= expectedDeaths);
        deathObserver.reset();
    }


    @Then("a fight took place")
    public void aFightTookPlace() {
        assertTrue(fightObserver.hasFightOccurred(), "Expected a fight to have taken place, but no fight was observed.")
        fightObserver.reset();
    }

    @Then("all characters fight")
    public void allCharactersFight() {
        int numDeaths = deathObserver.getNumDeaths()
        assertTrue(fightObserver.hasFightOccurred(), "Expected a fight to have taken place, but no fight was observed.")
        assertEquals(world.polymorphia.getLivingAdventurers().size() + numDeaths,fightObserver.getNumFights(),"Expected number of fights equal to number of living characters.")
        fightObserver.reset();
    }

    @Then("I should be told that either all the adventurers or all of the creatures have died")
    void iShouldBeToldThatEitherAllTheAdventurersOrAllOfTheCreaturesHaveDied() {
        assertTrue(gameOverObserver.receivedGameOverMessage())
    }

    @Then("the game should be over")
    void theGameShouldBeOver() {
        assertTrue(world.polymorphia.isOver());
    }

    @Then("creature {string} lost some health")
    public void creatureLostSomeHealth(String creatureName) {
        assertEquals(creatureName, lostHealthObserver.getNameOfCharacterWhoLostHealth(), "Expected '$creatureName' to have lost health, but it did not.")
        lostHealthObserver.reset(); // Reset for future checks
    }


    @Then("{string} dies")
    public void characterDies(String characterName) {
        assertTrue(deathObserver.getDeadCharacters().contains(characterName))
    }


    @Then("{string} eats the food")
    public void gluttonEatsTheFood(String adventurerName) {
        assertEquals(adventurerName, ateFoodObserver.getNameOfCharacterWhoAteFood(), "Expected '$adventurerName' to have eaten food, but it did not.")
        ateFoodObserver.reset();
    }

    @Then("{string} does not eat the food")
    public void gluttonDoesNotEatTheFood(String adventurerName) {
        assertNotEquals(adventurerName, ateFoodObserver.getNameOfCharacterWhoAteFood(), "Expected '$adventurerName' to have not eaten food, but it did.")
        ateFoodObserver.reset();
    }

    @Then("{string} runs")
    public void theCowardRuns(String adventurerName) {
        String characterWhoRan = moveObserver.getNameOfCharacterWhoMoved();
        String origin = moveObserver.getOrigin()
        String destination = moveObserver.getDestination()
        assertEquals(adventurerName,characterWhoRan,"Character who moved did not match $adventurerName.")
        assertNotEquals(origin,destination,"Origin and Destination were supposed to be different, but were not.")
        moveObserver.reset()
    }

    @Then("there should be at least {int} deaths")
    public validateDeathCount(int minDeaths){
        assertTrue(deathObserver.getNumDeaths() >= minDeaths)
    }


}
