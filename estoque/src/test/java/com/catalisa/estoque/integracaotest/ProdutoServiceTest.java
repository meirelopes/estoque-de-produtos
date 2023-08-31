package com.catalisa.estoque.integracaotest;

import com.catalisa.estoque.api.disassembler.ProdutoDtoDisassembler;
import com.catalisa.estoque.api.dto.entrada.ProdutoEntrada;
import com.catalisa.estoque.domain.exception.EntidadeNaoEncontradaException;
import com.catalisa.estoque.domain.model.ProdutoModel;
import com.catalisa.estoque.domain.service.ProdutoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestPropertySource("/application-test.properties")
public class ProdutoServiceTest {

    @Autowired
    ProdutoService produtoService;
    @Autowired
    ProdutoDtoDisassembler produtoDtoDisassembler;

    @Test
    public void deveCriarUmNovoProduto_QuandoSalvarProdutoComSucesso() {

        //Cenário
        ProdutoModel produto = new ProdutoModel();
        produto.setNome("Batom");
        produto.setPreco(new BigDecimal(30));
        produto.setQuantidade(1);
        produto.setMarca("Boticário");

        //Ação
        produto = produtoService.salvar(produto);

        //Validação
        Assertions.assertThat(produto).isNotNull();
        Assertions.assertThat(produto.getId()).isNotNull();

    }

    @Test()
    public void deveLancarExcecao_QuandoTentarSalvarProdutoSemNome() {

        //Cenário
        ProdutoEntrada produto = new ProdutoEntrada();
        produto.setNome("");
        produto.setPreco(new BigDecimal(30));
        produto.setQuantidade(1);
        produto.setMarca("Boticário");

        //Ação
        ProdutoModel produtoModel = produtoDtoDisassembler.toDomainModel(produto);
        ConstraintViolationException erroEsperado =
                assertThrows(ConstraintViolationException.class, () -> {
                    produtoService.salvar(produtoModel);
                });

        assertThat(erroEsperado).isNotNull();
    }

    @Test()
    public void deveLancarExcecao_QuandoTentarBuscarProdutoComIdInvalido() {

        //Ação

        EntidadeNaoEncontradaException erroEsperado =
                assertThrows(EntidadeNaoEncontradaException.class, () -> {
                    produtoService.excluir(00L);
                });

        //Validação

        assertThat(erroEsperado).isNotNull();
    }

}
