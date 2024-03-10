package org.facul.relatorio.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "vendas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataDaVenda;

    private String nomeDoVendedor;

    @OneToMany(mappedBy = "venda", fetch = FetchType.LAZY)
    private List<Produto> produtos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "relatorio_id")
    private Relatorio relatorio;

    public Venda(LocalDate dataDaVenda, String nomeDoVendedor, List<Produto> produtos, Relatorio relatorio) {
        this.dataDaVenda = dataDaVenda;
        this.nomeDoVendedor = nomeDoVendedor;
        this.produtos = produtos;
        this.relatorio = relatorio;
    }

    public Venda(LocalDate dataDaVenda, String nomeDoVendedor) {
        this.dataDaVenda = dataDaVenda;
        this.nomeDoVendedor = nomeDoVendedor;
    }
}
