package com.catalisa.estoque.api.disassembler;

import com.catalisa.estoque.api.dto.entrada.ProdutoEntrada;
import com.catalisa.estoque.api.dto.saida.produto.ProdutoResumidoDto;
import com.catalisa.estoque.domain.model.ProdutoModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoDtoDisassembler {

    @Autowired
    ModelMapper modelMapper;


    public ProdutoModel toDomainModel(ProdutoEntrada produtoEntrada) {

        return modelMapper.map(produtoEntrada, ProdutoModel.class);

    }

    public ProdutoModel toDomainModel2(ProdutoResumidoDto produtoResumidoDto) {

        return modelMapper.map(produtoResumidoDto, ProdutoModel.class);

    }


}
