CREATE TABLE vendas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_da_venda DATE,
    nome_do_vendedor VARCHAR(255),
    relatorio_id BIGINT
);