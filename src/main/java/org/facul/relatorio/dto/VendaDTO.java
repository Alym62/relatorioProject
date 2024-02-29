package org.facul.relatorio.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import org.facul.relatorio.domain.Produto;
import org.facul.relatorio.domain.Relatorio;

import java.time.LocalDate;
import java.util.List;

public record VendaDTO(
        @FutureOrPresent(message = "A data da venda precisa ser presente ou futuro.")
        LocalDate dataDaVenda,

        @NotBlank(message = "Não pode ser null ou vazio.")
        String nomeDoVendedor,

        List<Produto> produtos,

        Relatorio relatorio
) {
}
