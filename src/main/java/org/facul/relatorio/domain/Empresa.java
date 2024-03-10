package org.facul.relatorio.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "empresas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cnpj;

    @Column(unique = true)
    private String razaoSocial;

    @OneToOne(mappedBy = "empresa", fetch = FetchType.LAZY)
    private Relatorio relatorio;

    public Empresa(String cnpj, String razaoSocial, Relatorio relatorio) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.relatorio = relatorio;
    }

    public Empresa(String cnpj, String razaoSocial) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }
}
