# Java Lead Deduplicator REST API

## Overview
This Java Spring Boot application provides a REST API for de-duplicating leads. It accepts a JSON payload of lead records, processes them to remove duplicates according to predefined rules, and returns the deduplicated list.

## Preface
This program is created for a coding challenge interview. This is the REST API endpoint version.

## Requirements
- Java JDK 11 or later
- Maven

## Build the project
Use Maven to build the project and create an executable JAR file.

    mvn clean package

## Run the application
Once the build is successful, you can run the application using the following command:

    java -jar target/<jar-file-name>.jar
Replace <jar-file-name> with the name of the generated JAR file in the target directory. This command starts the application and the embedded Tomcat server.

## Using the Deduplicate Endpoint
The application exposes a /deduplicate endpoint that accepts POST requests with a JSON payload of lead records.

Endpoint
URL: /deduplicate
Method: POST
Content-Type: application/json
Payload: JSON array of lead records
Example Request
You can use tools like curl or Postman to send a request to the deduplicate endpoint. Here's an example using curl:

    curl -X POST http://localhost:8080/deduplicate \
    -H "Content-Type: application/json" \
    -d '{
    "leads": [
    {
    "_id": "jkj238238jdsnfsj23",
    "email": "foo@bar.com",
    "firstName":  "John",
    "lastName": "Smith",
    "address": "123 Street St",
    "entryDate": "2014-05-07T17:30:20+00:00"
    },
    {
    "_id": "edu45238jdsnfsj23",
    "email": "mae@bar.com",
    "firstName":  "Ted",
    "lastName": "Masters",
    "address": "44 North Hampton St",
    "entryDate": "2014-05-07T17:31:20+00:00"
    }
    // Add more records as needed
    ]
    }'
Replace the JSON payload with the actual records you wish to deduplicate. The service processes the payload and returns a deduplicated list of records based on the logic defined in the application.