# Links to github repositories for Food Trunk task. 

Backend api :
https://github.com/wenzhemint/rostorv-api

Frontend app:
https://github.com/wenzhemint/foodtrunk-app

# foodtrunk-api

Build Restful API for a simple Facility-Taking api using Spring Boot, Mysql, JPA and Hibernate.

## Used Version

1. Java - 21.0.x

2. Maven - 3.9.x

3. Mysql - 7.4.x

## Steps to Setup

**1. Clone the application**

git clone https://github.com/wenzhemint/foodtrunk-api.git

**2. Create Mysql database**

create database and tables by importing the sql file - `data/foodtrunk_db.sql`

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Build and run the app using maven**

mvn package

java -jar target/easy-notes-1.0.0.jar

Alternatively, you can run the app without packaging it using -

mvn spring-boot:run

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app provides following APIs.

    GET /api/facilities?address=CALIFORNIA
    
    GET /api/facilities/{fid}

You can test them using postman or any other rest client.

