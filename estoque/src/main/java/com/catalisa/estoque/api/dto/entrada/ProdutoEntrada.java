package com.catalisa.estoque.api.dto.entrada;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoEntrada {

    private Long id;
    @NotBlank
    private String nome;

    @NotBlank
    private BigDecimal preco;

    @NotBlank
    private Integer quantidade;

    @NotBlank
    private String marca;

    private String descricao;

    private String categoria;

    private String tamanho;

}
