# Monefy automation

## Test plan

### Balance tests

#### Expense 
##### Expense button
##### Expense by category
#### Income
#### Balance resume

### Date range selection tests

### Admin tests

#### Categories
#### Accounts
#### Currencies
#### Settings

### Search tests


## Prerequisite to run automated tests
To run this project, please assure that the prerequisite are attended.
1. Android studio and SDK 11 installed
   1. An Android Virtual Device with *Name=Pixel3a* and *System Image = R x86 , API Level = 30*
1. Appium cli installed
   1. run on command line *npm install -g appium*. I had to use *--force* but this is not recommended.
1. JDk installed. I used *java version 11.0.10 2021-01-19 LTS*

## Running
This project was developed on Eclipse IDE, Windows 10.
To run, first start the Android simulator and only after it finished, run the tests from Eclipse IDE.

## Stack used

The stack for this project is 
1. Java
1. Eclipse
3. Maven
4. Appium
5. Junit
6. Android SDK

Currently I'm working with C# but I decided to go with Java as a way to push myself since there is almost 3.5 years that I don't use Java and I believe that the role is Java, so to be sure that this will not be a blocker for me. I've choosen Maven over Gradle due to a greater familiarity with the tool, since I've worked only in one project with Gradle.
As test runner I've choosen Junit over TestNG for simplicity as I believe TestNG has a some advantages, but due the time I decided to go with the simpler option, since JUnit is by defalut on project.
I've chosen Android SDK because I don't have a mac. :)
Finally I've selected Appium to mobile test automation due to it's similarity with Selenium and I have some experience on it, so due to time again, I believe this was the correct choice.

