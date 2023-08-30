package com.catalisa.estoque.api.dto.saida.produto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoDto {

    private Long id;

    private String nome;

    private BigDecimal preco;

    private String descricao;

    private Integer quantidade;

}
