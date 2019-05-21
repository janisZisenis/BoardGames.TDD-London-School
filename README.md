# BoardGames.TDD

## Introduction

This project is meant to be a Kata to train my skills in **designing high quality software** using the **test-driven development** (TDD) initially described by Kent Beck (TDD - By Example, 2002). In addition to that I forced to apply (or at least tried to apply in every single test) Osherove's aspects of **high quality unit tests** (The Art of Unit Testing, 2014). Most of the patterns (e.g. logstring), principles (e.g. Direct/Indirect Input/Output), prefixes/suffixes (e.g. for Test Doubles) and so on are to be found in the following books:

* [Test Driven Development. By Example; Kent Beck](https://www.amazon.de/Test-Driven-Development-Example-Signature/dp/0321146530/ref=sr_1_1?hvadid=174418276756&hvdev=c&hvlocphy=9043313&hvnetw=g&hvpos=1t1&hvqmt=e&hvrand=17704527276239390355&hvtargid=kwd-11367315361&keywords=tdd+by+example&qid=1558295104&s=gateway&sr=8-1)
* [The Art of Unit Testing; Roy Osherove](https://www.amazon.de/Art-Unit-Testing-Roy-Osherove/dp/1617290890/ref=sr_1_1?hvadid=174672266071&hvdev=c&hvlocphy=9043313&hvnetw=g&hvpos=1t1&hvqmt=e&hvrand=2716020097760218298&hvtargid=kwd-10979390115&keywords=the+art+of+unit+testing&qid=1558288735&s=gateway&sr=8-1)
* [xUnit Test Patterns: Refactoring Test Code; Gerard Meszaros](https://www.amazon.de/xUnit-Test-Patterns-Refactoring-Signature/dp/0131495054/ref=sr_1_fkmrnull_1?crid=2ONRXE79AP40N&keywords=xunit+test+patterns&qid=1558288764&s=gateway&sprefix=xunit+test%2Caps%2C165&sr=8-1-fkmrnull)
* [Growing Object-Oriented Software, Guided By Tests; Steve Freeman and Nat Pryce](https://www.amazon.de/Growing-Object-Oriented-Software-Addison-Wesley-Signature/dp/0321503627/ref=sr_1_fkmrnull_1?crid=36Y4UQD5PG64Q&keywords=growing+objectoriented+software+guided+by+tests&qid=1558295137&s=gateway&sprefix=Growing+object+orie%2Caps%2C175&sr=8-1-fkmrnull)

For those who are new to TDD, these are the rules and aspects I strictly obeyed:
 * Rules/Phases of the TDD cycle:
   * Red - Write a failing unit test!
   * Green - Make the test pass in the simplest manner you can think of!
   * Refactoring - Clean up (and generify the production code if possible)!
   * Repeat!
* Aspects of high quality unit tests:
   * Trustworthiness (through consistency and isolation)
   * Readability
   * Maintainability

... nevertheless I won't omit the general tool set of the software craftmanship, the design principles! Especially in the phase Red, the principles (SOLID, etc.) support the programmer to discover different ways a specific task/behaviour can be represented in software. (In general the most readable, maintainable and trustworthy tests conform to the design principles.)

Besides training my skills in test-driving a system, this project serves as a personal investigation to which extent the test-centric development and pure following of the TDD rules/instructions leads to high quality systems by itself. (To evaluate the quality of the system I use the well-known metrics like cohesion and coupling and McCall's internal quality factors.)

If you're interested in TDD, feel free to enter my code and make your own conclusion. The unit tests should explain the system and serve as documentation of the system. In addition to that I attached some UML-like diagrams to visualise the most interesting/important parts/modules of the system.

## The Exercise - BoardGames App

As exercise I decided to implement a system containing the most known board games in java, which are to be executed as gui application (using JavaFX) as well as console application.

The intended board games are:

* TicTacToe :white_check_mark:
* Conway's Game of Life
* Four in a Row
* BattleShip
* Draughts
* Chess

## Executing the code

**Maven**

BoardGames.TDD is a maven project. To build it just download it and run the desired maven command in the terminal.

Assuming the path to the project's folder (where the root pom.xml is placed) is <path/to/project> you should execute the following commands to build the executable jar files:

```console
foo@bar:~$ cd <path/to/project>
foo@bar:~$ mvn package
```

To execute the different applications afterwards navigate in the app's target folders and execute the jars with dependencies.

FXBoardGames.Main:
```console
foo@bar:~$ cd <path/to/project>/Apps/FXBoardGames/target
foo@bar:~$ java -jar FXBoardGames-1.0-jar-with-dependencies.jar
```

TicTacToe.SequentialGui.Main:
```console
foo@bar:~$ cd <path/to/project>/Apps/TicTacToe.SequentialGui/target/
foo@bar:~$ java -jar TicTacToe.SequentialGui-1.0-jar-with-dependencies.jar
```

TicTacToe.Console.Main:
```console
foo@bar:~$ cd <path/to/project>/Apps/TicTacToe.Console/target/
foo@bar:~$ java -jar TicTacToe.Console-1.0-jar-with-dependencies.jar
```

**IntelliJ IDEA**

I developed the project using IntelliJ IDEA, so everything should work fine. But sometimes, however, IntelliJ has some problems finding or downloading the dependecies. In that case you could try..

1. ... to toggle the maven offline mode.

2. ... to use IntelliJ's build in maven (maven explorer at the right) to clean and package the project under **tictactoe-tdd (root)/Lifecycle**.

3. ... clear the .idea folder (losing all the Run/Debug Configurations I already generated) and reopen the !!pom.xml!! (not the containing folder).

4. ... Invalidate Cache and Restart.

## *NOTE:*
I'm sorry about not updating the documentation after every single step or state change of the system. As you know the state of software is (or should be) flexible, therefore changes to the system are likely going to happen. That's why a too precise documentation is not maintainable and not a good idea. But in this Kata the resulting state of the system is exactly what matters, so I will really try to keep it up to date. If the documentation does not match the code, please refer to the unit tests as they can't lie about what the system really does.

Have fun exploring my work, thanks for reading and enjoy!

Janis Zisenis
