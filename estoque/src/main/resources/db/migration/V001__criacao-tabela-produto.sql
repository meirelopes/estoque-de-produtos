CREATE TABLE tb_produto (
    id serial PRIMARY KEY,
    categoria VARCHAR(50),
    descricao TEXT,
    marca VARCHAR(50),
    nome VARCHAR(50),
    preco DECIMAL(10, 2),
    quantidade INT,
    tamanho VARCHAR(50)
);