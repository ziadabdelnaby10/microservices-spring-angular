package com.example.product;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.HttpStatus;
import org.testcontainers.containers.MongoDBContainer;

import java.math.BigDecimal;

//@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

    @ServiceConnection
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongodb/mongodb-community-server:latest");

    static {
        mongoDBContainer.start();
    }

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    void shouldCreateProduct() {
        String requestBody = """
                {
                    "name":"IPhone 13",
                    "description":"IPhone 13 is a smartphone from apple",
                    "price":1000
                }
                """;
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/product/create")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("id" , Matchers.notNullValue())
                .body("name" , Matchers.equalTo("IPhone 13"))
                .body("description" , Matchers.equalTo("IPhone 13 is a smartphone from apple"))
                .body("price" , Matchers.equalTo(1000));

    }

}
