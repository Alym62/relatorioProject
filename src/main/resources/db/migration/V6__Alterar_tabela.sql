ALTER TABLE relatorio_empresa
ADD CONSTRAINT fk_empresa
FOREIGN KEY (empresa_id) REFERENCES empresas(id);

ALTER TABLE relatorio_empresa
ADD CONSTRAINT fk_relatorio
FOREIGN KEY (relatorio_id) REFERENCES relatorios(id);


-- Adicionar chave estrangeira na tabela Produto
ALTER TABLE produtos
ADD CONSTRAINT fk_produto_venda
FOREIGN KEY (venda_id) REFERENCES vendas(id);

-- Adicionar chave estrangeira na tabela Venda
ALTER TABLE vendas
ADD CONSTRAINT fk_venda_relatorio
FOREIGN KEY (relatorio_id) REFERENCES relatorios(id);