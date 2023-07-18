# PruebaDane

## Development

 `localhost:8080`.

## Build

The application can be built using the following command:

```
gradlew clean build
```

The application can then be started with the following command - here with the profile `production`:

```
java -Dspring.profiles.active=production -jar ./build/libs/prueba-dane-0.0.1-SNAPSHOT.jar
```

## Further readings

* [Gradle user manual](https://docs.gradle.org/)  
* [Spring Boot reference](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)  
* [Spring Data JPA reference](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)  
