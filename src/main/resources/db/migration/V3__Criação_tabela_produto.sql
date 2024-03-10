CREATE TABLE produtos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_do_produto VARCHAR(255),
    descricao VARCHAR(255),
    valor_do_produto DOUBLE,
    venda_id BIGINT,
    tipo_produto VARCHAR(255)
);