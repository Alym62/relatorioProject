CREATE TABLE relatorios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_do_periodo_de_analise DATE,
    resumo VARCHAR(255),
    receita_total DOUBLE,
    total_de_vendas INT
);
