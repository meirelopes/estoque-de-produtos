package com.catalisa.estoque.api.controller;

import com.catalisa.estoque.api.assembler.ProdutoDtoAssembler;
import com.catalisa.estoque.api.disassembler.ProdutoDtoDisassembler;
import com.catalisa.estoque.api.dto.entrada.ProdutoEntrada;
import com.catalisa.estoque.api.dto.saida.produto.ProdutoDto;
import com.catalisa.estoque.api.dto.saida.produto.ProdutoResumidoDto;
import com.catalisa.estoque.domain.model.ProdutoModel;
import com.catalisa.estoque.domain.service.ProdutoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @Autowired
    ProdutoDtoAssembler produtoDtoAssembler;

    @Autowired
    ProdutoDtoDisassembler produtoDtoDisassembler;

    @GetMapping
    public List<ProdutoResumidoDto> listar() {

        return produtoDtoAssembler.toCollectionProdutoResumidoDto(produtoService.listar());

    }

    @GetMapping(path = "/por-nome")
    public ResponseEntity<List<ProdutoResumidoDto>> listarPorNome(@RequestParam("nome") String nome) {
        List<ProdutoResumidoDto> produtos = produtoDtoAssembler
                .toCollectionProdutoResumidoDto(produtoService.listarPorNome(nome));

        if (produtos.isEmpty()) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(produtos);
    }


    @GetMapping(path = "/{produtoId}")
    public ProdutoDto buscar(@PathVariable Long produtoId) {

        ProdutoDto produtoDto =  produtoDtoAssembler.toDto(produtoService.buscar(produtoId));
        return produtoDto;

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProdutoDto adicionar(@RequestBody @Valid ProdutoEntrada produtoEntrada) {

        ProdutoModel produtoModel = produtoDtoDisassembler.toDomainModel(produtoEntrada);

        ProdutoDto produtoDto = produtoDtoAssembler.toDto(produtoService.salvar(produtoModel));

        return produtoDto;

    }
    @PutMapping(path = "/{produtoId}")
    public ProdutoDto atualizar(@PathVariable Long produtoId, @RequestBody @Valid ProdutoEntrada produtoEntrada) {

        ProdutoModel produtoEntradaToModel = produtoDtoDisassembler.toDomainModel(produtoEntrada);

        ProdutoModel produtoAtual = produtoService.buscar(produtoId);

        BeanUtils.copyProperties(produtoEntradaToModel, produtoAtual, "id");

        ProdutoDto produtoDto = produtoDtoAssembler.toDto(produtoService.salvar(produtoAtual));

        return produtoDto;

    }

    @DeleteMapping(path = "/{produtoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long produtoId) {

        produtoService.excluir(produtoId);

    }

}
