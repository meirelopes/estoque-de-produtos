delete from tb_produto;
ALTER SEQUENCE tb_produto_id_seq RESTART WITH 1;
INSERT INTO tb_produto (nome, preco, descricao, quantidade, marca, categoria, tamanho) VALUES ('shampoo cabelos oleosos', 45.5, 'Shampoo para cabelos oleosos limpeza profunda', 23, 'Loreal', 'shampoo', '400 ml');
INSERT INTO tb_produto (nome, preco, descricao, quantidade, marca, categoria, tamanho) VALUES ('shampoo cabelos cacheados', 50.5, 'Shampoo para cabelos cacheados com hidratação profunda', 15, 'Loreal', 'shampoo', '400 ml');
INSERT INTO tb_produto (nome, preco, descricao, quantidade, marca, categoria, tamanho) VALUES ('shampoo cabelos normais', 45.5, 'Shampoo para cabelos normais de uso diário', 10, 'Loreal', 'shampoo', '400 ml');
INSERT INTO tb_produto (nome, preco, descricao, quantidade, marca, categoria, tamanho) VALUES ('condicionador cabelos oleosos', 45.5, 'Condicionador para cabelos oleosos limpeza profunda', 23, 'Loreal', 'condicionador', '250 ml');
INSERT INTO tb_produto (nome, preco, descricao, quantidade, marca, categoria, tamanho) VALUES ('condicionador cabelos cacheados', 50.5, 'Condicionador para cabelos cacheados com hidratação profunda', 15, 'Loreal', 'condicionador', '250 ml');
INSERT INTO tb_produto (nome, preco, descricao, quantidade, marca, categoria, tamanho) VALUES ('condicionador cabelos normais', 45.5, 'Condicionador para cabelos normais de uso diário', 10, 'Loreal', 'condicionador', '250 ml');
INSERT INTO tb_produto (nome, preco, descricao, quantidade, marca, categoria, tamanho) VALUES ('creme sem enxague', 45.5, 'Creme sem enxague para cabelos cacheados', 23, 'Loreal', 'creme sem enxague', '400 ml');
INSERT INTO tb_produto (nome, preco, descricao, quantidade, marca, categoria, tamanho) VALUES ('creme sem enxague', 45.5, 'Protetor térmico para cabelos normais', 13, 'Loreal', 'creme sem enxague', '300 ml');
INSERT INTO tb_produto (nome, preco, descricao, quantidade, marca, categoria, tamanho) VALUES ('creme sem enxague', 15, 'Creme sem enxague para cabelos cacheados', 23, 'Skala', 'creme sem enxague', '400 ml');
INSERT INTO tb_produto (nome, preco, descricao, quantidade, marca, categoria, tamanho) VALUES ('creme de hidratação', 45.5, 'Hidratação profunda', 3, 'Loreal', 'creme de hidratação', '500 ml');
INSERT INTO tb_produto (nome, preco, descricao, quantidade, marca, categoria, tamanho) VALUES ('creme de hidratação', 45.5, 'Hidratação profunda para cabelos cacheados', 12, 'Loreal', 'creme de hidratação', '500 ml');
INSERT INTO tb_produto (nome, preco, descricao, quantidade, marca, categoria, tamanho) VALUES ('creme de hidratação', 45.5, 'Hidratação para cabelos loiros', 5, 'Loreal', 'creme de hidratação', '500 ml');
INSERT INTO tb_produto (nome, preco, descricao, quantidade, marca, categoria, tamanho) VALUES ('Creme corporal', 45.5, 'Creme para o corpo com hidratação profunda', 23, 'Nivea', 'Creme corporal', '400 ml');
INSERT INTO tb_produto (nome, preco, descricao, quantidade, marca, categoria, tamanho) VALUES ('Creme para rosto', 45.5, 'Creme para rosto de uso noturno', 23, 'Nivea', 'creme para rosto', '100 ml');
INSERT INTO tb_produto (nome, preco, descricao, quantidade, marca, categoria, tamanho) VALUES ('Creme para rosto', 45.5, 'Creme para rosto de uso diurno', 23, 'Nivea', 'creme para rosto', '100 ml');

