package org.facul.relatorio.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.facul.relatorio.domain.enums.TipoProduto;

@Entity
@Table(name = "produtos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeDoProduto;

    private String descricao;

    private Double valorDoProduto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venda_id")
    private Venda venda;

    @Enumerated(EnumType.STRING)
    private TipoProduto tipoProduto;

    public Produto(String nomeDoProduto, String descricao, Double valorDoProduto, Venda venda, TipoProduto tipoProduto) {
        this.nomeDoProduto = nomeDoProduto;
        this.descricao = descricao;
        this.valorDoProduto = valorDoProduto;
        this.venda = venda;
        this.tipoProduto = tipoProduto;
    }

    public Produto(String nomeDoProduto, String descricao, Double valorDoProduto, TipoProduto tipoProduto) {
        this.nomeDoProduto = nomeDoProduto;
        this.descricao = descricao;
        this.valorDoProduto = valorDoProduto;
        this.tipoProduto = tipoProduto;
    }
}
