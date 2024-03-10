package org.facul.relatorio.controller;

import org.facul.relatorio.controller.base.BaseController;
import org.facul.relatorio.domain.Relatorio;
import org.facul.relatorio.dto.request.RelatorioRequestDTO;
import org.facul.relatorio.dto.response.RelatorioResponseDTO;
import org.facul.relatorio.service.RelatorioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/relatorio")
public class RelatorioController extends BaseController<Relatorio, Long, RelatorioRequestDTO, RelatorioResponseDTO, RelatorioService> {
    protected RelatorioController(RelatorioService service) {
        super(service);
    }
}
