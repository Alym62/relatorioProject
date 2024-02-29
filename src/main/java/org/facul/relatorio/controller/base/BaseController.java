package org.facul.relatorio.controller.base;

import org.facul.relatorio.service.base.BaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<T, ID, DTO, S extends BaseService<T, ID, DTO>> {
    protected final S service;

    protected BaseController(S service) {
        this.service = service;
    }

    @GetMapping("/todos")
    public List<DTO> buscarTodos() {
        return service.buscarPorTodos();
    }

    @GetMapping("/{id}")
    public DTO buscarPorId(@PathVariable ID id) {
        return service.buscarPorId(id)
                .orElseThrow(null);
    }

    @PostMapping("/salvar")
    public DTO salvar(@RequestBody DTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/atualizar/{id}")
    public DTO atualizar(@PathVariable ID id, @RequestBody DTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable ID id) {
        service.deletar(id);
    }
}
