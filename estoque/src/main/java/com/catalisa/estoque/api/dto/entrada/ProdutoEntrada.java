package com.catalisa.estoque.api.dto.entrada;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoEntrada {

    private Long id;

    private String nome;

    private BigDecimal preco;

    private String descricao;

    private Integer quantidade;

}
