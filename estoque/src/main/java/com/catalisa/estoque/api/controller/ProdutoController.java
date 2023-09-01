package com.catalisa.estoque.api.controller;

import com.catalisa.estoque.api.assembler.ProdutoDtoAssembler;
import com.catalisa.estoque.api.disassembler.ProdutoDtoDisassembler;
import com.catalisa.estoque.api.dto.entrada.ProdutoEntrada;
import com.catalisa.estoque.api.dto.saida.produto.ProdutoDto;
import com.catalisa.estoque.api.dto.saida.produto.ProdutoResumidoDto;
import com.catalisa.estoque.api.openapi.controller.ProdutoControllerOpenApi;
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
public class ProdutoController implements ProdutoControllerOpenApi {

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

        ProdutoDto produtoDto = produtoDtoAssembler.toDto(produtoService.buscar(produtoId));
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
