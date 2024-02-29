package org.facul.relatorio.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.facul.relatorio.domain.enums.TipoProduto;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "vendas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataDaVenda;

    private String nomeDoVendedor;

    @OneToMany(mappedBy = "venda")
    private List<Produto> produtos;

    @ManyToOne
    @JoinColumn(name = "relatorio_id")
    private Relatorio relatorio;
}
