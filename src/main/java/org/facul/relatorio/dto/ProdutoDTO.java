package org.facul.relatorio.dto;

import jakarta.validation.constraints.NotBlank;
import org.facul.relatorio.domain.Venda;
import org.facul.relatorio.domain.enums.TipoProduto;

public record ProdutoDTO(
        @NotBlank(message = "Não pode ser null ou vazio.")
        String nomeDoProduto,

        @NotBlank(message = "Não pode ser null ou vazio.")
        String descricao,

        Double valorDoProduto,

        Venda venda,

        TipoProduto tipoProduto
) {
}
