package org.facul.relatorio.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "relatorios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Relatorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataDoPeriodoDeAnalise;

    private String resumo;

    private Double receitaTotal;

    private Integer totalDeVendas;

    @OneToMany(mappedBy = "relatorio", fetch = FetchType.LAZY)
    private List<Venda> vendas;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "relatorio_empresa",
            joinColumns = {@JoinColumn(name = "empresa_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "relatorio_id", referencedColumnName = "id")}
    )
    private Empresa empresa;

    public Relatorio(LocalDate dataDoPeriodoDeAnalise, String resumo, Double receitaTotal, Integer totalDeVendas, List<Venda> vendas, Empresa empresa) {
        this.dataDoPeriodoDeAnalise = dataDoPeriodoDeAnalise;
        this.resumo = resumo;
        this.receitaTotal = receitaTotal;
        this.totalDeVendas = totalDeVendas;
        this.vendas = vendas;
        this.empresa = empresa;
    }

    public Relatorio(LocalDate dataDoPeriodoDeAnalise, String resumo, Double receitaTotal, Integer totalDeVendas) {
        this.dataDoPeriodoDeAnalise = dataDoPeriodoDeAnalise;
        this.resumo = resumo;
        this.receitaTotal = receitaTotal;
        this.totalDeVendas = totalDeVendas;
    }
}
