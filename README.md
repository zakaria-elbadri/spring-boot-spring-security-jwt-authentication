# Spring Boot JWT Authentication example with Spring Security & Spring Data JPA

## Front-end project
You can find here : https://github.com/zakaria-elbadri/react-redux-jwt-auth the front-end project (developed with React) for this back-end server.

## Dependency
– If you want to use PostgreSQL:

```
<dependency>
  <groupId>org.postgresql</groupId>
  <artifactId>postgresql</artifactId>
  <scope>runtime</scope>
</dependency>
```
– or MySQL:

```
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <scope>runtime</scope>
</dependency>
```
## Configure Spring Datasource, JPA, App properties
Open `src/main/resources/application.properties`
- For PostgreSQL:

```
# Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
spring.datasource.url=jdbc:postgresql://localhost:5432/testdb
spring.datasource.username=postgres
spring.datasource.password=123

# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto=update

# App Properties
app.jwtSecret=appSecretKey
app.jwtExpirationMs=86400000
```
- For MySQL

```
# Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
spring.datasource.url=jdbc:mysql://localhost:3306/testdb?useSSL=false
spring.datasource.username=root
spring.datasource.password=123456

# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto=update

# App Properties
app.jwtSecret=appSecretKey
app.jwtExpirationMs=86400000
```

## Run Spring Boot application
```
mvn spring-boot:run
```

## Run following SQL insert statements
```
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```

## Register some users with /signup API

- admin with ROLE_ADMIN
- moderator with ROLE_MODERATOR and ROLE_USER
- user with ROLE_USER

Example adding an admin user
- URL : http://localhost:8080/api/auth/signup

```
{
  "username": "admin",
  "email": "admin@app.com",
  "password": "123456",
  "role": ["admin", "moderator", "user"]
}
```
