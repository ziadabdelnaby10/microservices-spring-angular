
```markdown
# 🛠️ Microservices with Spring Boot and Angular

This project is a Spring Boot-based microservices architecture, designed to build scalable and resilient applications. It utilizes **Spring Cloud**, **Spring Data JPA**, and integrates tools for logging, monitoring, and API documentation. The frontend is built using **Angular** to provide a seamless user interface. The project is focused on leveraging Spring Boot features for backend services.

## 🚀 Features

- **Spring Boot Microservices**: Provides the backend services with REST APIs.
- **Spring Cloud Gateway**: For routing and handling cross-cutting concerns like security and rate limiting.
- **Resilience4j Circuit Breaker**: Ensures fault tolerance by providing circuit breaker functionality.
- **OAuth2 Resource Server**: Handles authentication and authorization of APIs.
- **Spring Actuator**: Provides production-ready features like health checks, metrics, and monitoring.
- **Springdoc OpenAPI**: Automatically generates API documentation for the backend.
- **Prometheus & Micrometer**: For application metrics and monitoring.
- **Loki & Logback**: Centralized logging with Loki.
- **Spring Data JPA**: Easily manage relational databases with JPA repositories.
  
## 🧑‍💻 Technologies Used

### Backend (Java Spring Boot)
- **Spring Boot**: The main framework for building the microservices.
- **Spring Cloud Gateway**: API Gateway for routing and filtering.
- **Resilience4j**: Circuit breaker and retry mechanisms for resiliency.
- **Spring Security OAuth2**: OAuth2 resource server to handle authentication.
- **Spring Actuator**: Monitoring and operational insights into the system.
- **Spring Data JPA**: For easy integration with relational databases.
- **Springdoc OpenAPI**: API documentation generation using OpenAPI specification.
- **Prometheus**: Metrics collection with Micrometer.
- **Loki & Logback**: Centralized logging using Loki and Logback appender.

### Frontend (Angular)
- **Angular**: A modern web framework for building dynamic, single-page applications (SPA).

## 🔧 Getting Started

### Prerequisites
Before you begin, ensure you have the following installed:

- **Java 17+** (for running Spring Boot)
- **Maven** (for dependency management and project build)
- **Node.js** and **Angular CLI** (for the frontend)
- **Docker** (optional, for containerized deployments)
- **IDE** (IntelliJ IDEA, Eclipse, or Visual Studio Code)

### Backend Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/microservices-spring-angular.git
   cd microservices-spring-angular
   ```

2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

3. Run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

   By default, the application will start on `http://localhost:8080`.

4. The backend is now running! You can check the health endpoints or access the API documentation at `http://localhost:8080/swagger-ui.html` (thanks to Springdoc OpenAPI).

### Frontend Setup

1. Navigate to the Angular frontend directory:
   ```bash
   cd frontend
   ```

2. Install the required dependencies:
   ```bash
   npm install
   ```

3. Run the Angular development server:
   ```bash
   ng serve
   ```

4. Access the Angular app at `http://localhost:4200` in your browser.

### Database Setup

This project uses different databases for different microservices:

- **Product Microservice**: Uses **MongoDB** for storing product-related data.
- **Order & Inventory Microservices**: Use **MySQL** for relational data storage.

#### MongoDB (Product Microservice)

1. Ensure MongoDB is installed and running locally or use a cloud-based MongoDB service.
2. Configure the connection settings in the `application.properties` (or `application.yml`) file for the **Product Microservice**:
   ```properties
   spring.data.mongodb.uri=mongodb://localhost:27017/productdb
   ```

   Replace `localhost` with your MongoDB server host and `productdb` with your desired database name.

#### MySQL (Order & Inventory Microservices)

1. Ensure MySQL is installed and running locally or use a cloud-based MySQL service.
2. Configure the connection settings in the `application.properties` (or `application.yml`) file for the **Order** and **Inventory Microservices**:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/orderdb
   spring.datasource.username=root
   spring.datasource.password=password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
   ```

   Replace the `localhost`, `orderdb`, `root`, and `password` with your MySQL server host, database name, username, and password for the **Order Microservice**. You’ll need to repeat similar steps for the **Inventory Microservice**, adjusting the database name accordingly.

#### Additional Database Configurations

- Ensure that the corresponding MongoDB and MySQL drivers are included in the `pom.xml` dependencies (which should already be handled by Spring Boot if you followed the standard setup).
- MongoDB and MySQL-specific properties such as connection pool settings can also be configured as needed for performance and scalability.

Once the databases are properly configured and running, the application should be able to connect to each respective database for its respective microservices.

### Monitoring & Logging

- **Prometheus**: Application metrics will be exposed at `/actuator/prometheus`. You can configure Prometheus to scrape metrics from this endpoint.
  
- **Loki**: Logs can be pushed to Loki using the configured `logback` appender. You'll need a Loki instance set up to collect logs.

### API Documentation

This project uses **Springdoc OpenAPI** to automatically generate the API documentation. Access it at:

- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **OpenAPI Spec**: `http://localhost:8080/v3/api-docs`

## 🛠️ Project Structure

```
/backend
 ├── /src
 │    ├── /main
 │    │    ├── /java
 │    │    ├── /resources
 │    ├── /test
 ├── pom.xml
/frontend
 ├── /src
 │    ├── /app
 │    ├── /assets
 ├── package.json
 ├── angular.json
README.md
```

- **backend/**: Contains the Spring Boot backend microservices.
- **frontend/**: Contains the Angular frontend application.
- **README.md**: Project documentation.

## 📚 Documentation

- **API Documentation**: Generated by **Springdoc OpenAPI**, available at `/swagger-ui.html`.
- **Actuator Endpoints**: 
  - `/actuator/health` - Health status of the services.
  - `/actuator/metrics` - Metrics exposed for monitoring tools.
  