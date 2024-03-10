package org.facul.relatorio.dto.response;

import java.time.LocalDate;

public record RelatorioResponseDTO(
        Long id,

        LocalDate dataDoPeriodoDeAnalise,

        String resumo,

        Double receitaTotal,

        Integer totalDeVendas
) {
}
