# Makersharks Supplier Search API

This project is a proof of concept for a RESTful API that allows buyers to search for manufacturers based on their customized requirements.

## Requirements
- Java 17
- Maven
- MySQL

## Getting Started

1. Clone the repository.
2. Set up the MySQL database.
3. Configure the application properties in `src/main/resources/application.properties`.
4. Run the application using `mvn spring-boot:run`.

## API Documentation

Swagger documentation is available at `http://localhost:8080/swagger-ui/`.

### Example Query

```bash
curl -X POST "http://localhost:8080/api/supplier/query" -d "location=India&natureOfBusiness=SMALL_SCALE&manufacturingProcess=THREE_D_PRINTING&page=0&size=10"