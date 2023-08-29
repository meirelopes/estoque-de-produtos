package com.catalisa.estoque.api.controller;

import com.catalisa.estoque.domain.model.ProdutoModel;
import com.catalisa.estoque.domain.service.ProdutoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    /*
    Sistema de Gerenciamento de Estoque
Descrição:
Desenvolver um sistema de gerenciamento de estoque usando o Spring
Framework e um banco de dados PostgreSQL. O sistema permitirá a criação,
atualização, leitura e exclusão de produtos no estoque por meio de requisições
HTTP. As interações com o sistema serão simuladas usando o Postman.
Requisitos:
● Utilizar o Spring Framework (Spring Boot, Spring Data JPA) para criar a
aplicação.
● Usar um banco de dados PostgreSQL ou H2 para armazenar os dados dos
produtos.
● Criar endpoints REST para as operações CRUD (criação, leitura, atualização,
exclusão) de produtos.
● Permitir a criação de novos produtos com informações como nome,
descrição, preço e quantidade que deseja armazenar.
● Possibilitar a atualização dos detalhes de um produto existente.
● Permitir a obtenção da lista de todos os produtos ou de um produto
específico por ID ou nome.
● Possibilitar a exclusão de produtos.
● Implementar tratamento de erros e exceções apropriados.
● Implementar testes unitários com cobertura de 100%.
● Documentar a API com o Swagger, tornando-a compreensível para outros
desenvolvedores.
Como entregar os exercícios:
Documentar a entrega marcando no classroom e adicionar o link do
repositório do GitHub contendo o código do desafio, enviar também a sua
API documentada pelo swagger e collection do postman contendo todas
as suas requisições
     */

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public List<ProdutoModel> listar() {

        return produtoService.listar();

    }

    @GetMapping(path = "/por-nome")
    public ResponseEntity<List<ProdutoModel>> listarPorNome(@RequestParam("nome") String nome) {
        List<ProdutoModel> produtos = produtoService.listarPorNome(nome);

        if (produtos.isEmpty()) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(produtos);
    }


    @GetMapping(path = "/{produtoId}")
    public ProdutoModel buscar(@PathVariable Long produtoId) {

        return produtoService.buscar(produtoId);

    }

    @PostMapping
    public ProdutoModel adicionar(@RequestBody ProdutoModel produtoModel) {

        return produtoService.salvar(produtoModel);

    }
    @PutMapping(path = "/{produtoId}")
    public ProdutoModel atualizar(@PathVariable Long produtoId, @RequestBody ProdutoModel produto) {

        ProdutoModel produtoAtual = produtoService.buscar(produtoId);
        BeanUtils.copyProperties(produto, produtoAtual, "id");
        return produtoService.salvar(produtoAtual);

    }
    @DeleteMapping(path = "/{produtoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long produtoId) {

        produtoService.excluir(produtoId);

    }

}
