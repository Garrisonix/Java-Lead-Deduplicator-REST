# Deduplication Program

## Overview
This Java program is designed to deduplicate a set of records based on specific rules. It takes a JSON file as input, processes the records to remove duplicates, and outputs the deduplicated records. The program handles duplicates by preferring records with the newest dates and resolves conflicts by choosing the last record provided in case of identical dates.

## Preface
This program was made for a coding challenge interview. There is a REST API version as well.

## Requirements
- Java JDK 11 or later
- Maven

## Setup
Clone the repository to your local machine using the following command:

    git clone https://github.com/Garrisonix/Java-Lead-Deduplicator

Navigate to the project directory:

    cd Java-Lead-Deduplicator

## Building the Project
To build the project, run the following Maven command from the root of the project directory:

    mvn clean package

This command compiles the project and packages it into a runnable JAR file, including all dependencies.

## Running the Program
To run the program, use the following command, optionally specifying the path to your JSON file as an argument. If no argument is provided, the program defaults to using `leads.json`.

    java -jar target/Java-Lead-Deduplicator-1.0-SNAPSHOT.jar [path/to/yourfile.json]

Example:

    java -jar target/Java-Lead-Deduplicator-1.0-SNAPSHOT.jar

Or, if specifying a file:

    java -jar target/Java-Lead-Deduplicator-1.0-SNAPSHOT.jar custom_leads.json

## Running Tests
This project uses JUnit for testing. To run the tests, execute the following Maven command:

    mvn test

This will run all tests included in the `src/test/java` directory and output the results, showing whether the tests passed or failed.

