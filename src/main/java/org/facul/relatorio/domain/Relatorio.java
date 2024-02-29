package org.facul.relatorio.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "relatorios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Relatorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataDoPeriodoDeAnalise;

    private String resumo;

    private Double receitaTotal;

    private Integer totalDeVendas;

    @OneToMany(mappedBy = "relatorio")
    private List<Venda> vendas;

    @OneToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
}
