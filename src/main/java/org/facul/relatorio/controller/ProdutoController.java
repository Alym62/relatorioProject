package org.facul.relatorio.controller;

import org.facul.relatorio.controller.base.BaseController;
import org.facul.relatorio.domain.Produto;
import org.facul.relatorio.dto.request.ProdutoRequestDTO;
import org.facul.relatorio.dto.response.ProdutoResponseDTO;
import org.facul.relatorio.service.ProdutoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/produto")
public class ProdutoController extends BaseController<Produto, Long, ProdutoRequestDTO, ProdutoResponseDTO, ProdutoService> {
    protected ProdutoController(ProdutoService service) {
        super(service);
    }
}
