package org.facul.relatorio.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import org.facul.relatorio.domain.Empresa;
import org.facul.relatorio.domain.Venda;

import java.time.LocalDate;
import java.util.List;

public record RelatorioDTO(
        @FutureOrPresent(message = "A data de analise precisa ser presente ou futuro.")
        LocalDate dataDoPeriodoDeAnalise,

        @NotBlank(message = "Não pode ser null ou vazio.")
        String resumo,

        Double receita,

        Integer totalDeVendas,

        List<Venda> vendas,

        Empresa empresa
) { }
