## Spring Boot Personal Framework

## Requirements:
* Java 17
* Maven 3.6.3
* Spring Boot 3.3.2
* Postgres 13

## Dependencies
* Project Reactor
* Spring Reactive Programming

## How To Develop It
- Create Data Migration
- Create Repository
- Create Command Pattern
- Create Controller
- Create Integration Testing

## Recommendation Tools
- IntelliJ IDEA Community Version

## How to run the project

1. Clone the repository

```shell
git clone {git-repository-url}
```

2. Run migrations on the database

```shell
cd springbot-personal-migration/

mvn flyway:migrate
```

3. Run the following command to start the project

```shell
mvn spring-boot:run
```

4. The project will start on port 8080

## How to run the tests

Run the following command to run the tests

```shell
mvn test
```

## API Documentation
After running the application, you can access the API documentation on [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## How to clean the project
```shell
mvn clean
```

This framework It's inspired by:
* [Blibli Backend Framework](https://github.com/bliblidotcom/blibli-backend-framework)
* [Spring Command Pattern](https://github.com/khannedy/spring-command-pattern)
