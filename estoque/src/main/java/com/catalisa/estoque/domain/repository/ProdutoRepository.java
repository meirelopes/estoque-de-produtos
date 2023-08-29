package com.catalisa.estoque.domain.repository;

import com.catalisa.estoque.domain.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

    List<ProdutoModel> findTodosByNomeContaining(String nome);

}
