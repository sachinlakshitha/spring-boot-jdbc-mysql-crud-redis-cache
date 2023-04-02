# Spring Boot JDBC + MySQL CRUD + Redis Cache Example

This is a simple Spring Boot application that demonstrates how to use Spring JDBC to perform CRUD operations on MySQL database and store them in memory cache using Redis.

## Requirements

1. Java 17
2. Maven 3
3. MySQL 8.x.x
4. Redis 7.x.x

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/sachinlakshitha/spring-boot-jdbc-mysql-crud-redis-cache.git
```

**2. Change MySQL username and password as per your MySQL installation**

+ open `src/main/resources/application.properties` file.

+ change `spring.datasource.username` and `spring.datasource.password` properties as per your mysql installation

**3. Change Redis host and port as per your Redis installation**

+ open `src/main/resources/application.properties` file.

+ change `spring.data.redis.host` and `spring.data.redis.port` properties as per your redis installation

**4. Build and run the app using maven**

```bash
mvn package
java -jar target/spring-boot-jdbc-mysql-crud-redis-cache-1.0.0-SNAPSHOT.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.
