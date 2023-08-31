package com.catalisa.estoque.util;

import com.catalisa.estoque.domain.model.ProdutoModel;
import com.catalisa.estoque.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class GeradorDeDados {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void prepararDados() {

        ProdutoModel produto1 = new ProdutoModel();
        produto1.setNome("shampoo cabelos oleosos");
        produto1.setPreco(new BigDecimal("45.5"));
        produto1.setDescricao("Shampoo para cabelos oleosos limpeza profunda");
        produto1.setQuantidade(23);
        produto1.setMarca("Loreal");
        produto1.setCategoria("shampoo");
        produto1.setTamanho("400 ml");
        produtoRepository.save(produto1);

        ProdutoModel produto2 = new ProdutoModel();
        produto2.setNome("shampoo cabelos cacheados");
        produto2.setPreco(new BigDecimal("50.5"));
        produto2.setDescricao("Shampoo para cabelos cacheados com hidratação profunda");
        produto2.setQuantidade(15);
        produto2.setMarca("Loreal");
        produto2.setCategoria("shampoo");
        produto2.setTamanho("400 ml");
        produtoRepository.save(produto2);

        ProdutoModel produto3 = new ProdutoModel();
        produto3.setNome("shampoo cabelos normais");
        produto3.setPreco(new BigDecimal("45.5"));
        produto3.setDescricao("Shampoo para cabelos normais de uso diário");
        produto3.setQuantidade(10);
        produto3.setMarca("Loreal");
        produto3.setCategoria("shampoo");
        produto3.setTamanho("400 ml");
        produtoRepository.save(produto3);

        ProdutoModel produto4 = new ProdutoModel();
        produto4.setNome("condicionador cabelos oleosos");
        produto4.setPreco(new BigDecimal("45.5"));
        produto4.setDescricao("Condicionador para cabelos oleosos limpeza profunda");
        produto4.setQuantidade(23);
        produto4.setMarca("Loreal");
        produto4.setCategoria("condicionador");
        produto4.setTamanho("250 ml");
        produtoRepository.save(produto4);

        ProdutoModel produto5 = new ProdutoModel();
        produto5.setNome("condicionador cabelos cacheados");
        produto5.setPreco(new BigDecimal("50.5"));
        produto5.setDescricao("Condicionador para cabelos cacheados com hidratação profunda");
        produto5.setQuantidade(15);
        produto5.setMarca("Loreal");
        produto5.setCategoria("condicionador");
        produto5.setTamanho("250 ml");
        produtoRepository.save(produto5);

        ProdutoModel produto6 = new ProdutoModel();
        produto6.setNome("creme sem enxague");
        produto6.setPreco(new BigDecimal("45.5"));
        produto6.setDescricao("Creme sem enxague para cabelos cacheados");
        produto6.setQuantidade(23);
        produto6.setMarca("Loreal");
        produto6.setCategoria("creme sem enxague");
        produto6.setTamanho("400 ml");
        produtoRepository.save(produto6);

        ProdutoModel produto7 = new ProdutoModel();
        produto7.setNome("creme sem enxague");
        produto7.setPreco(new BigDecimal("45.5"));
        produto7.setDescricao("Protetor térmico para cabelos normais");
        produto7.setQuantidade(13);
        produto7.setMarca("Loreal");
        produto7.setCategoria("creme sem enxague");
        produto7.setTamanho("300 ml");
        produtoRepository.save(produto7);

        ProdutoModel produto8 = new ProdutoModel();
        produto8.setNome("creme sem enxague");
        produto8.setPreco(new BigDecimal("15"));
        produto8.setDescricao("Creme sem enxague para cabelos cacheados");
        produto8.setQuantidade(23);
        produto8.setMarca("Skala");
        produto8.setCategoria("creme sem enxague");
        produto8.setTamanho("400 ml");
        produtoRepository.save(produto8);

        ProdutoModel produto9 = new ProdutoModel();
        produto9.setNome("creme de hidratação");
        produto9.setPreco(new BigDecimal("45.5"));
        produto9.setDescricao("Hidratação profunda");
        produto9.setQuantidade(3);
        produto9.setMarca("Loreal");
        produto9.setCategoria("creme de hidratação");
        produto9.setTamanho("500 ml");
        produtoRepository.save(produto9);

        ProdutoModel produto10 = new ProdutoModel();
        produto10.setNome("creme de hidratação");
        produto10.setPreco(new BigDecimal("45.5"));
        produto10.setDescricao("Hidratação profunda para cabelos cacheados");
        produto10.setQuantidade(12);
        produto10.setMarca("Loreal");
        produto10.setCategoria("creme de hidratação");
        produto10.setTamanho("500 ml");
        produtoRepository.save(produto10);

        ProdutoModel produto11 = new ProdutoModel();
        produto11.setNome("creme de hidratação");
        produto11.setPreco(new BigDecimal("45.5"));
        produto11.setDescricao("Hidratação para cabelos loiros");
        produto11.setQuantidade(5);
        produto11.setMarca("Loreal");
        produto11.setCategoria("creme de hidratação");
        produto11.setTamanho("500 ml");
        produtoRepository.save(produto11);

        ProdutoModel produto12 = new ProdutoModel();
        produto12.setNome("Creme corporal");
        produto12.setPreco(new BigDecimal("45.5"));
        produto12.setDescricao("Creme para o corpo com hidratação profunda");
        produto12.setQuantidade(23);
        produto12.setMarca("Nivea");
        produto12.setCategoria("Creme corporal");
        produto12.setTamanho("400 ml");
        produtoRepository.save(produto12);

        ProdutoModel produto13 = new ProdutoModel();
        produto13.setNome("Creme para rosto");
        produto13.setPreco(new BigDecimal("45.5"));
        produto13.setDescricao("Creme para rosto de uso noturno");
        produto13.setQuantidade(23);
        produto13.setMarca("Nivea");
        produto13.setCategoria("creme para rosto");
        produto13.setTamanho("100 ml");
        produtoRepository.save(produto13);

    }

}
