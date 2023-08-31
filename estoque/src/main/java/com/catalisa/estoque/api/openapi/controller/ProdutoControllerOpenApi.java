package com.catalisa.estoque.api.openapi.controller;

import com.catalisa.estoque.api.dto.entrada.ProdutoEntrada;
import com.catalisa.estoque.api.dto.saida.produto.ProdutoDto;
import com.catalisa.estoque.api.dto.saida.produto.ProdutoResumidoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
@Tag(name = "Produtos")
public interface ProdutoControllerOpenApi {

        @Operation(summary = "Listar", description = "Listar produtos")
        List<ProdutoResumidoDto> listar();

        @Operation(summary = "Listar por nome", description = "Lista os produtos que correspondem ao nome fornecido como parâmetro de busca")
        ResponseEntity<List<ProdutoResumidoDto>> listarPorNome(String nome);

        @Operation(summary = "Buscar por id", description = "Busca um produto informando o seu id")
        public ProdutoDto buscar(@Parameter(description = "ID de uma cidade", example = "1", required = true)
                                         Long produtoId);

        @Operation(summary = "Cadastrar produto", description = "Cadastra um novo produto")
        ProdutoDto adicionar(@io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Representação de um novo produto", required = true) ProdutoEntrada produtoEntrada);

        @Operation(summary = "Atualizar por id", description = "Atualiza um produto buscando pelo seu id")
        ProdutoDto atualizar(@Parameter(description = "ID de um produto", example = "1", required = true)
                             Long produtoId, @RequestBody(description = "Representação de um produto " +
                "com dados atualizados", required = true) ProdutoEntrada produtoEntrada);

        @Operation(summary = "Excluir por id", description = "Exclui um produto informando o seu id")
        void deletar(@Parameter(description = "ID de um produto", example = "1", required = true)
                     Long produtoId);

}
