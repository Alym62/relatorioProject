package org.facul.relatorio.controller;

import org.facul.relatorio.controller.base.BaseController;
import org.facul.relatorio.domain.Empresa;
import org.facul.relatorio.dto.request.EmpresaRequestDTO;
import org.facul.relatorio.dto.response.EmpresaResponseDTO;
import org.facul.relatorio.service.EmpresaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/empresa")
public class EmpresaController extends BaseController<Empresa, Long, EmpresaRequestDTO, EmpresaResponseDTO, EmpresaService> {
    protected EmpresaController(EmpresaService service) {
        super(service);
    }

    @PostMapping("/vincular/empresa/{idEmpresa}/relatorio/{relatorioId}")
    public ResponseEntity<String> vincularRelatorio(@PathVariable Long idEmpresa, @PathVariable Long relatorioId) {
        service.vincularRelatorio(relatorioId, idEmpresa);

        return ResponseEntity.ok("Vinculado com sucesso!");
    }
}
