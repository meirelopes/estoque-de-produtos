package com.catalisa.estoque.api.dto.saida.produto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoResumidoDto {
    @Schema(example = "1")
    private Long id;

    @Schema(example = "Shampoo Micelar")
    private String nome;

    @Schema(example = "25.50")
    private BigDecimal preco;

    @Schema(example = "5")
    private Integer quantidade;

}
