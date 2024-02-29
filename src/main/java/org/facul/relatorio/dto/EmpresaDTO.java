package org.facul.relatorio.dto;

import jakarta.validation.constraints.NotBlank;
import org.facul.relatorio.domain.Relatorio;
import org.hibernate.validator.constraints.br.CNPJ;

public record EmpresaDTO (
        @CNPJ(message = "Erro ao cadastrar o CNPJ. Tente um CNPJ válido.")
        String cnpj,

        @NotBlank(message = "Não pode ser null ou vazio.")
        String razaoSocial,

        Relatorio relatorio
) { }
