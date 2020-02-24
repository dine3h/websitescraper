
#Website Scraper

This project provides a tool for scraping information from a public website. In this particular
instance, information about berries is being collected from Sainsbury's supermarket website.

##Getting Started

Download or clone from GIT and then use Maven 3.1.1 (or better) and Java 1.8 (or better).


##Installation

To build, test and run the project run the following commands in your terminal from the project directory:

###Step 1
Compile the project and generate the target folder. Also,
run the automated tests.
`mvn test`

###Step 2
Execute the program
`mvn exec:java -Dexec.mainClass=com.dineshkaushish.app.App`

##Notes
###Tests are not exhaustive but it has been recognised that with more time they could have been improved:
1. Implementing tests for all possible scenarios
2. Implementing verification calls using something like Mockito

###Program could be further modularised by breaking up the scrape website class by two ways;

1. Encapsulate details into other classes
2. Use private methods which are terrible for testing independently.

###Could not get omission of zero calories to work

1. Some issue with Jackson, perhaps requires a rollback to an earlier version to rectify bug.

Please note no input is required for the application. The expected output is JSON string in your console.

##Authors

Dinesh Kaushish - Initial contributor

##License

This project is licensed under the MIT License - see the LICENSE.md file for details
