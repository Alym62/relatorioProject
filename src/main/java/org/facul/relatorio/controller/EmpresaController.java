package org.facul.relatorio.controller;

import org.facul.relatorio.controller.base.BaseController;
import org.facul.relatorio.domain.Empresa;
import org.facul.relatorio.dto.EmpresaDTO;
import org.facul.relatorio.service.EmpresaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/empresa")
public class EmpresaController extends BaseController<Empresa, Long, EmpresaDTO, EmpresaService> {
    protected EmpresaController(EmpresaService service) {
        super(service);
    }
}
