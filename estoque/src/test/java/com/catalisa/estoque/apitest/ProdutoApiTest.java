package com.catalisa.estoque.apitest;

import com.catalisa.estoque.domain.model.ProdutoModel;
import com.catalisa.estoque.domain.repository.ProdutoRepository;
import com.catalisa.estoque.util.DatabaseCleaner;
import com.catalisa.estoque.util.GeradorDeDados;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
public class ProdutoApiTest {
    @LocalServerPort
    private int port;

    @Autowired
    private DatabaseCleaner databaseCleaner;
    @Autowired
    private GeradorDeDados geradorDeDados;
    @Autowired
    private ProdutoRepository produtoRepository;

    @BeforeEach
    public void setup() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.port = port;
        databaseCleaner.clearTables();
        geradorDeDados.prepararDados();

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
        ProdutoModel produto = getProduto();

        RestAssured
                .given()
                .basePath("/produtos/" + produto.getId())
                .accept(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(HttpStatus.OK.value());

    }


    @Test
    public void deveRetornarStatus204_QuandoDeletarUmProduto() {
        ProdutoModel produto = getProduto();

        RestAssured
                .given()
                .basePath("/produtos/"+produto.getId())
                .accept(ContentType.JSON)
                .when()
                .delete()
                .then()
                .statusCode(HttpStatus.NO_CONTENT.value());

    }

    @Test
    public void deveRetornarStatus200_QuandoConsultarProdutosBuscandoPorNomes() {
        ProdutoModel produto = new ProdutoModel();

        RestAssured
                .given()
                .basePath("/produtos/por-nome")
                .param("nome", produto.getNome())
                .accept(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(HttpStatus.OK.value());

    }

    private ProdutoModel getProduto() {
        ProdutoModel produto = new ProdutoModel();
        produto.setNome("Creme para rosto");
        produto.setPreco(new BigDecimal("45.5"));
        produto.setDescricao("Creme para rosto de uso diurno");
        produto.setQuantidade(23);
        produto.setMarca("Nivea");
        produto.setCategoria("creme para rosto");
        produto.setTamanho("100 ml");
        produtoRepository.save(produto);
        return produto;
    }

}
