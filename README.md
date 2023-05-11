# SpringBootSoapWebServiceDemo
Java Spring Boot SOAP WS Example

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- [PostgreSQL Database](https://www.postgresql.org/)

## Running the application locally

### Database configuration
First, create a user in the database with name "soap". Use password "password".
Then, create a database with name "soap-example". The owner must be the user that we created("soap").
Spring will take care of creating the tables for us. 

### Running the server 
There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.example.spring.soap.api.SpringBootSoapWebServiceDemoApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
