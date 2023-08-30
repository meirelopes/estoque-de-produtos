package com.catalisa.estoque.api.assembler;

import com.catalisa.estoque.api.dto.saida.produto.ProdutoDto;
import com.catalisa.estoque.api.dto.saida.produto.ProdutoResumidoDto;
import com.catalisa.estoque.domain.model.ProdutoModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProdutoDtoAssembler {

    @Autowired
    ModelMapper modelMapper;

    public ProdutoDto toDto(ProdutoModel produtoModel) {

        return modelMapper.map(produtoModel, ProdutoDto.class);

    }

    public ProdutoResumidoDto toResumidoDto(ProdutoModel produtoModel) {

        return modelMapper.map(produtoModel, ProdutoResumidoDto.class);

    }

    public List<ProdutoResumidoDto> toCollectionProdutoResumidoDto(List<ProdutoModel> produtosModel) {

        List<ProdutoResumidoDto> produtosResumidoDto = new ArrayList<>();

        for (ProdutoModel produtoModel : produtosModel) {

            produtosResumidoDto.add(toResumidoDto(produtoModel));

        }

        return produtosResumidoDto;
    }


}
