package org.facul.relatorio.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.facul.relatorio.domain.Relatorio;
import org.hibernate.validator.constraints.br.CNPJ;

public record EmpresaRequestDTO(
        @CNPJ(message = "{EmpresaDTO.cnpj}")
        String cnpj,

        @NotBlank(message = "{empresaDTO.razaoSocial}")
        String razaoSocial,

        Relatorio relatorio
) { }
