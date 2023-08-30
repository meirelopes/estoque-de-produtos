package com.catalisa.estoque.mockmvc;

import com.catalisa.estoque.api.assembler.ProdutoDtoAssembler;
import com.catalisa.estoque.api.controller.ProdutoController;
import com.catalisa.estoque.api.disassembler.ProdutoDtoDisassembler;
import com.catalisa.estoque.api.dto.entrada.ProdutoEntrada;
import com.catalisa.estoque.api.dto.saida.produto.ProdutoDto;
import com.catalisa.estoque.api.dto.saida.produto.ProdutoResumidoDto;
import com.catalisa.estoque.domain.model.ProdutoModel;
import com.catalisa.estoque.domain.service.ProdutoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProdutoController.class)
@Import({ProdutoDtoAssembler.class, ProdutoDtoDisassembler.class, ModelMapper.class})
public class ProdutoControllerTesteMockMvc {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    ProdutoService produtoService;
    @Autowired
    ProdutoDtoDisassembler produtoDtoDisassembler;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    ProdutoDtoAssembler produtoDtoAssembler;
    @Autowired
    ModelMapper modelMapper;

    @Test
    public void deveRetornarStatusCreatedEUmProduto_QuandoCadastrarUmProduto() throws Exception {

        ProdutoEntrada produtoEntrada = new ProdutoEntrada();
        produtoEntrada.setId(1L);
        produtoEntrada.setNome("Escova de Cabelo");
        produtoEntrada.setMarca("Loreal");
        produtoEntrada.setPreco(new BigDecimal(30));
        produtoEntrada.setQuantidade(5);

        ProdutoModel produtoModel = produtoDtoDisassembler.toDomainModel(produtoEntrada);

        ProdutoDto produtoDto = produtoDtoAssembler.toDto(produtoModel);

        Mockito.when(produtoService.salvar(produtoModel)).thenReturn(produtoModel);

        mockMvc.perform(MockMvcRequestBuilders.post("/produtos")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(produtoModel)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nome").value("Escova de Cabelo"))
                .andExpect(jsonPath("$.marca").value("Loreal"))
                .andExpect(jsonPath("$.preco").value(30))
                .andExpect(jsonPath("$.quantidade").value(5));
    }

    @Test
    public void deveDeletarProduto_QuandoChamarDeletarProduto() throws Exception {

        Long produtoId = 1L;
        Mockito.doNothing().when(produtoService).excluir(produtoId);

        mockMvc.perform(MockMvcRequestBuilders.delete("/produtos/{produtoId}", produtoId))
                .andExpect(status().isNoContent());

        Mockito.verify(produtoService, Mockito.times(1)).excluir(produtoId);
    }



   /* @Test
    public void deveRetornarStatusOkEUmProduto_QuandoAtualizarUmProduto2() throws Exception {

        ProdutoModel produtoModel = produtoService.buscar(1L);

        ProdutoEntrada produtoEntrada = new ProdutoEntrada();
        produtoEntrada.setNome("Escova de Cabelo");
        produtoEntrada.setMarca("Loreal");
        produtoEntrada.setPreco(new BigDecimal(30));
        produtoEntrada.setQuantidade(5);
        produtoEntrada.setCategoria("Escovas");
        produtoEntrada.setTamanho("20 cm");
        produtoEntrada.setDescricao("Sem descrição");

        produtoModel = produtoDtoDisassembler.toDomainModel(produtoEntrada);

        ProdutoDto produtoDto = produtoDtoAssembler.toDto(produtoModel);

        Mockito.when(produtoService.salvar(produtoModel)).thenReturn(produtoModel);

        mockMvc.perform(MockMvcRequestBuilders.put("/produtos/{produtoId}", 1)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(produtoModel)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nome").value("Escova de Cabelo"))
                .andExpect(jsonPath("$.marca").value("Loreal"))
                .andExpect(jsonPath("$.preco").value(30))
                .andExpect(jsonPath("$.quantidade").value(5));
    }
    @Test
    public void deveRetornarStatusOkEUmProduto_QuandoAtualizarUmProduto() throws Exception {
        // Primeiro, buscar o produto existente a ser atualizado
        ProdutoModel produtoModelExistente = new ProdutoModel();

        // Criar um objeto ProdutoEntrada com os novos dados
        ProdutoEntrada produtoEntrada = new ProdutoEntrada();
        produtoEntrada.setId(1L);
        produtoEntrada.setNome("Escova de Cabelo");
        produtoEntrada.setMarca("Loreal");
        produtoEntrada.setPreco(new BigDecimal(30));
        produtoEntrada.setQuantidade(5);
        produtoEntrada.setCategoria("Escovas");
        produtoEntrada.setTamanho("20 cm");
        produtoEntrada.setDescricao("Sem descrição");

        // Converter o ProdutoEntrada em ProdutoModel usando o disassembler
        ProdutoModel produtoModelNovo = produtoDtoDisassembler.toDomainModel(produtoEntrada);

        // Copiar os atributos do novo produto para o produto existente
        BeanUtils.copyProperties(produtoModelNovo, produtoModelExistente);
        System.out.println(produtoModelExistente.getNome());
        System.out.println(produtoModelNovo.getNome());

        // Configurar o comportamento do mock do serviço
        Mockito.when(produtoService.salvar(produtoModelExistente)).thenReturn(produtoModelExistente);

        // Fazer a requisição PUT e verificar o resultado
        mockMvc.perform(MockMvcRequestBuilders.put("/produtos/{produtoId}", 1)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(produtoEntrada)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nome").value("Escova de Cabelo"))
                .andExpect(jsonPath("$.marca").value("Loreal"))
                .andExpect(jsonPath("$.preco").value(30))
                .andExpect(jsonPath("$.quantidade").value(5));
    }*/

    @Test
    public void deveRetornarStatusOkEUmaListaDeProdutos_QuandoListarProdutosw() throws Exception {

        List<ProdutoResumidoDto> produtosResumidos = new ArrayList<>();

        ProdutoResumidoDto produtoResumidoDto = new ProdutoResumidoDto();
        produtoResumidoDto.setId(1L);
        produtoResumidoDto.setNome("Produto1");
        produtosResumidos.add(produtoResumidoDto);
        List<ProdutoModel> produtoModels = new ArrayList<>();

        for (ProdutoResumidoDto p : produtosResumidos) {
            ProdutoModel produtoModel = produtoDtoDisassembler.toDomainModel2(produtoResumidoDto);
            produtoModels.add(produtoModel);
        }

        Mockito.when(produtoService.listar())
                .thenReturn(produtoModels);

    }

}
