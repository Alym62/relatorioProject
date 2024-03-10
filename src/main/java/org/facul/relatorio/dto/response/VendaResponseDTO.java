package org.facul.relatorio.dto.response;

import java.time.LocalDate;

public record VendaResponseDTO(
        Long id,

        LocalDate dataDaVenda,

        String nomeDoVendedor
) {
}
