package org.facul.relatorio.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.facul.relatorio.domain.enums.TipoProduto;

@Entity
@Table(name = "produtos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeDoProduto;

    private String descricao;

    private Double valorDoProduto;

    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;

    private TipoProduto tipoProduto;
}
