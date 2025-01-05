## Refactoring with Strategy and Command Patterns
Game modifications:
- If adventurers are in the room with the Demon, the Demon will fight the healthiest one
- If no adventurers are in the room, the Demon will move to a random neighboring room
- Use the Strategy Pattern to inject behavior into the Adventurer class so that we can create Characters that behave like our previous subclasses of Knight, Glutton, and Coward.
- Use the Strategy Pattern to do the same with Demon subclass of Creature.
- Use the Command Pattern to return the action to execute from the Strategy Pattern classes
- Use the Factory Pattern to create the Command objects

### Introduction
#### Team Members: 
Grace Ohlsen, Sierra Reschke and Nolan Brady 

#### Java Version: 21

#### Comments/Assumptions: 
We made the assumption that the flow of strategies would go fight, eat and move in terms of priority. All the tests passed therefore I think the logic stands.
We reworked the NoFood Exceptions to avoid having to pass the exception throwing up the method stack. This also passed in tests.
We also created strategies for different characters when there were variances in their movements as this seemed to be the cleanest approach to the different logic.


## Test Coverage
![](homework_7_tests.png)


## Game Extensions
* If adventurers are in the room with the Demon, the Demon will fight the healthiest one
* If no adventurers are in the room, the Demon will move to a random neighboring room

### Required Capabilities

* Use the Strategy Pattern to inject behavior into the Adventurer class so that we can create Characters that behave like our previous subclasses of Knight, Glutton, and Coward. 
* Use the Strategy Pattern to do the same with Demon subclass of Creature. 
* Use the Command Pattern to return the action to execute from the Strategy Pattern classes 
* Use the Factory Pattern to create the Command objects 

