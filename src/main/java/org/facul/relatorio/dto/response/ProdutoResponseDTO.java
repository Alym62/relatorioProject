package org.facul.relatorio.dto.response;

import org.facul.relatorio.domain.enums.TipoProduto;

public record ProdutoResponseDTO(
        Long id,

        String nomeDoProduto,

        String descricao,

        Double valorDoProduto,

        TipoProduto tipoProduto
) {
}
