-- Atualizando a tabela vendas com os ids dos relatórios
UPDATE vendas SET relatorio_id = 1 WHERE id = 1;
UPDATE vendas SET relatorio_id = 2 WHERE id = 2;
UPDATE vendas SET relatorio_id = 3 WHERE id = 3;

-- Atualizando a tabela produtos com os ids das vendas
UPDATE produtos SET venda_id = 1 WHERE id = 1;
UPDATE produtos SET venda_id = 1 WHERE id = 2;
UPDATE produtos SET venda_id = 2 WHERE id = 3;
UPDATE produtos SET venda_id = 3 WHERE id = 4;