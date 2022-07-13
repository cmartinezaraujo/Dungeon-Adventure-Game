# Dungeon Adventure Game

This project has been migrated from a private repository created in 2020 and owned by the other author of this project Alex Thornton. The original commit history is available [here](./GitHistory.xlsx).

## About the project

Dungeon Adventure was written in Java and uses the JUnit testing framework. The project was created using the PVP Dungeon game as a starting point and is included under DungeonSource. The files used where refactored and adapted to fit the project's needs. Design patters were used to make the game more flexible and scalable. The Strategy pattern was used to build an attack interface and the Flyweight pattern was used to store a pool of attacks. A more in depth look at the structure of the project can be found in the [UML Diagram](./DungeonDiagram.pdf).

## About the game

Dungeon Adventure is a simple terminal window game where the player chooses a Hero and is dropped into a dungeon. The objective is to find the four Pillars of OOP and escape the dungeon. While exploring the dungeon the user runs the risk of falling into pits or running into monsters which they must battle.

## Run and compile the game

From the command line at the root of the project, run the following command:

```javac -d ./classes ./Dungeon/*.java```

```javac -d ./classes ./Factories/*.java```

```cd ./classes```

```java Dungeon.DungeonAdventure```
