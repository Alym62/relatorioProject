package org.facul.relatorio.controller;

import org.facul.relatorio.controller.base.BaseController;
import org.facul.relatorio.domain.Venda;
import org.facul.relatorio.dto.request.VendaRequestDTO;
import org.facul.relatorio.dto.response.VendaResponseDTO;
import org.facul.relatorio.service.VendaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/venda")
public class VendaController extends BaseController<Venda, Long, VendaRequestDTO, VendaResponseDTO, VendaService> {
    protected VendaController(VendaService service) {
        super(service);
    }
}
