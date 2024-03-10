package org.facul.relatorio.controller.base;

import jakarta.validation.Valid;
import org.facul.relatorio.service.base.BaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<T, ID, DTORequest, DTOResponse, S extends BaseService<T, ID, DTORequest, DTOResponse>> {
    protected final S service;

    protected BaseController(S service) {
        this.service = service;
    }

    @GetMapping("/todos")
    public List<DTOResponse> buscarTodos() {
        return service.buscarPorTodos();
    }

    @GetMapping("/{id}")
    public DTOResponse buscarPorId(@PathVariable ID id) {
        return service.buscarPorId(id)
                .orElseThrow(null);
    }

    @PostMapping("/salvar")
    public DTORequest salvar(@RequestBody @Valid DTORequest dto) {
        return service.salvar(dto);
    }

    @PutMapping("/atualizar/{id}")
    public DTORequest atualizar(@PathVariable ID id, @RequestBody  @Valid  DTORequest dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable ID id) {
        service.deletar(id);
    }
}
