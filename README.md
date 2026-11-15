# Employee Management System

A RESTful backend application for managing employee records. It is built with Java 17, Spring Boot, Spring Data JPA, Bean Validation, Maven, and MySQL.

## Features

- Create, view, update, and delete employee records
- List all employees
- Search employees by name or department
- Validate incoming employee data
- Centralized API error responses
- Persist employee records in MySQL

> Authentication and role-based authorization are not included in this initial version. Add and test them before listing Spring Security as a project feature.

## Technology Stack

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA / Hibernate
- MySQL
- Maven
- Bean Validation

## Prerequisites

- JDK 17 or later
- Maven 3.9+
- MySQL 8+

## Database setup

Create a database (or allow the JDBC URL to create it):

```sql
CREATE DATABASE employee_management;
```

Set the following environment variables before running the application:

```text
DB_URL=jdbc:mysql://localhost:3306/employee_management?createDatabaseIfNotExist=true
DB_USERNAME=root
DB_PASSWORD=your_mysql_password
```

You can also update `src/main/resources/application.properties` for your local machine. Do not commit real database passwords.

## Run the application

From the project root:

```bash
mvn spring-boot:run
```

The API runs at `http://localhost:8080`.

## API endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/employees` | Create an employee |
| GET | `/api/employees` | Get all employees |
| GET | `/api/employees/{id}` | Get an employee by ID |
| PUT | `/api/employees/{id}` | Update an employee |
| DELETE | `/api/employees/{id}` | Delete an employee |
| GET | `/api/employees/search?keyword=...` | Search by name or department |

### Example request

```http
POST /api/employees
Content-Type: application/json
```

```json
{
  "firstName": "Aarav",
  "lastName": "Sharma",
  "email": "aarav.sharma@example.com",
  "department": "Engineering",
  "jobTitle": "Software Developer",
  "salary": 55000.00
}
```

## Project structure

```text
src/
  main/
    java/com/shakina/ems/
      EmployeeManagementApplication.java
      controller/
      dto/
      entity/
      exception/
      repository/
      service/
    resources/
      application.properties
  test/
    java/com/shakina/ems/
```

## Verify

Run the test suite:

```bash
mvn test
```

You can test the endpoints with Postman or curl.

## Future improvements

- Add Spring Security with role-based access control
- Add pagination and sorting
- Add API documentation with OpenAPI/Swagger
- Add integration tests using Testcontainers
- Add a frontend client

## License

This project is available under the MIT License. See `LICENSE`.
