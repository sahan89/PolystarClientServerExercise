## *Overview*
Exercise  Client-Server application for Polyster Elisa.

## *Prerequisites*
* Java 11
* Socket Programming
* Java Threads
* Gradle 


## *Build Project*
1. Create Database ```CREATE DATABASE zaizidb;```
2. Set Username and Password in the ```application.properties``` file
3. Clone the project
4. Navigate to root path (ShoppingCart)
5. Invoke ```bower install```
6. Invoke ```mvn clean install -DskipTests```
7. Navigate to target folder

## *Run Project*
* Invoke the following commands to run the Dracula Server Frankenstein Server and run the Client using the terminal.

*Run Dracula Server*
```./gradlew runDraculaServer```

*Run Frankenstein Server*
```./gradlew runFrankensteinServer```

*Run Client*
```./gradlew runClient```
