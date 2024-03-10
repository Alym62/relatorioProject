-- Inserindo dados na tabela empresas
INSERT INTO empresas (cnpj, razao_social) VALUES
    ('12345678901234', 'Empresa A'),
    ('56789012345678', 'Empresa B'),
    ('90123456789012', 'Empresa C');

-- Inserindo dados na tabela relatorios
INSERT INTO relatorios (data_do_periodo_de_analise, resumo, receita_total, total_de_vendas) VALUES
    ('2022-01-01', 'Resumo Relatório 1', 1500.50, 10),
    ('2022-02-01', 'Resumo Relatório 2', 2000.75, 15),
    ('2022-03-01', 'Resumo Relatório 3', 1800.20, 12);

-- Inserindo dados na tabela vendas
INSERT INTO vendas (data_da_venda, nome_do_vendedor) VALUES
    ('2022-01-15', 'Vendedor 1'),
    ('2022-02-10', 'Vendedor 2'),
    ('2022-03-05', 'Vendedor 3');

-- Inserindo dados na tabela produtos
INSERT INTO produtos (nome_do_produto, descricao, valor_do_produto, tipo_produto) VALUES
    ('Produto A', 'Descrição A', 50.00, 'HARDWARE'),
    ('Produto B', 'Descrição B', 30.50, 'HARDWARE'),
    ('Produto C', 'Descrição C', 25.75, 'HARDWARE'),
    ('Produto D', 'Descrição D', 40.00, 'HARDWARE');

INSERT INTO relatorio_empresa(empresa_id, relatorio_id) VALUES
    (1, 1),
    (2, 2),
    (3, 3);
