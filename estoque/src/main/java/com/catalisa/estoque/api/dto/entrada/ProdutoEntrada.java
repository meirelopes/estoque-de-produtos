package com.catalisa.estoque.api.dto.entrada;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoEntrada {

    private Long id;
    @NotBlank
    private String nome;

    @PositiveOrZero
    private BigDecimal preco;

    @PositiveOrZero
    private Integer quantidade;

    @NotBlank
    private String marca;

    private String descricao;

    private String categoria;

    private String tamanho;

}
