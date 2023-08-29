package com.catalisa.estoque.domain.service;

import com.catalisa.estoque.domain.exception.EntidadeNaoEncontradaException;
import com.catalisa.estoque.domain.model.ProdutoModel;
import com.catalisa.estoque.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<ProdutoModel> listar() {

        return produtoRepository.findAll();

    }

    public ProdutoModel buscar(Long produtoId) {
        Optional<ProdutoModel> produtoOptional = produtoRepository.findById(produtoId);

        if (produtoOptional.isPresent()) {
            return produtoOptional.get();
        } else {
            throw new EntidadeNaoEncontradaException("Não existe cadastro de produto com o código " + produtoId);
        }
    }

    @Transactional
    public ProdutoModel salvar(ProdutoModel produtoModel) {

        return produtoRepository.save(produtoModel);

    }
    @Transactional
    public void excluir(Long produtoId) {

        try {

            produtoRepository.deleteById(produtoId);

        } catch (EmptyResultDataAccessException e) {

            throw new EntidadeNaoEncontradaException("Não existe cadastro de produto com o código " + produtoId);

        }

    }

}
