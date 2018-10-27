# Java Workshop Rest API
Rest API example.  UI for this api [java-workshop-orders-ui](https://github.com/nradionov/java-workshop-orders-ui)

## Install
#### Requires the following:
- Java 8
- Maven 3
- Docker

## Start DB instance
### Run docker container
`docker run --name workshow-postgres --rm -it -p5432:5432 -e POSTGRES_DB=workshop-db -e POSTGRES_USER=user -e POSTGRES_PASSWORD=password postgres:9.6-alpine`

## Build
### Package application
`mvn clean package -DskipTests=true`

## Run application
### Run using command line
`java -jar target/java-workshop-rest-api-0.0.1-SNAPSHOT.jar`

## Check
### Retrieve an empty list of orders from db
Open your browser and go to the next page `http://localhost:8080/api/orders`

Try CRUD operations:

- GET http://localhost:8080/api/orders - get all orders
- GET http://localhost:8080/api/orders/{id} - get one by id
- POST http://localhost:8080/api/orders - create a new order
- PUT http://localhost:8080/api/orders/{id} - update existing order
- DELETE http://localhost:8080/api/orders/{id} - remove by id