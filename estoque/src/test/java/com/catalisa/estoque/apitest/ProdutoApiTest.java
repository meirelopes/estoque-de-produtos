package com.catalisa.estoque.apitest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProdutoApiTest {
    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.port = port;

    }

    @Test
    public void deveRetornarStatus200_QuandoConsultarProdutos() {

        RestAssured
                .given()
                .basePath("/produtos")
                .accept(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(HttpStatus.OK.value());

    }

    @Test
    public void deveRetornarStatus200_QuandoConsultarUmProduto() {


        RestAssured
                .given()
                .basePath("/produtos/1")
                .accept(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(HttpStatus.OK.value());
    }


}
