package com.catalisa.estoque.domain.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tb_produto")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String nome;

    @Column(nullable = false)
    @PositiveOrZero
    private BigDecimal preco;

    @Column(nullable = false)
    @PositiveOrZero
    private Integer quantidade;

    @Column(nullable = false)
    @NotBlank
    private String marca;

    @Column
    private String categoria;

    @Column
    private String tamanho;

    @Column
    private String descricao;

}
