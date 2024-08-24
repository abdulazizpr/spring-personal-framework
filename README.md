## Spring Boot Personal Framework

Requirements:
```text
- Java 17 
- Maven 3.6.3
- Spring Boot 3.3.2
- R2DBC
- Postgres 13
```

## How to run the project

1. Clone the repository

```shell
git clone 
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
5. You can access the swagger documentation on http://localhost:8080/swagger-ui.html

## How to run the tests

Run the following command to run the tests

```shell
mvn test
```

## How to clean the project
```shell
mvn clean
```
