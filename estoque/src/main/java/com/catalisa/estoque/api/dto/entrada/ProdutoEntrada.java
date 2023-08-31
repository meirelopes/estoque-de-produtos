package com.catalisa.estoque.api.dto.entrada;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoEntrada {

    @NotBlank
    @Schema(example = "Shampoo Micelar")
    private String nome;

    @Schema(example = "25.50")
    @PositiveOrZero
    @NotNull
    private BigDecimal preco;

    @PositiveOrZero
    @NotNull
    @Schema(example = "5")
    private Integer quantidade;

    @NotBlank
    @Schema(example = "Pantene")
    private String marca;

    @Schema(example = "Ideal para cabelos oleosos na raiz e opacos.")
    private String descricao;

    @Schema(example = "Shampoo")
    private String categoria;

    @Schema(example = "400 ml")
    private String tamanho;

}
