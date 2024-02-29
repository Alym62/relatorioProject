package org.facul.relatorio.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TipoProduto {
    ELETRONICO("Eletrônico"),
    GAMES("Consoles e games"),
    ROUPA("Roupas em geral"),
    HARDWARE("Hardware");

    private String name;
}
