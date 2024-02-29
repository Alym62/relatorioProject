package org.facul.relatorio.service;

import org.facul.relatorio.domain.Empresa;
import org.facul.relatorio.dto.EmpresaDTO;
import org.facul.relatorio.repository.EmpresaRepository;
import org.facul.relatorio.service.base.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaService extends BaseService<Empresa, Long, EmpresaDTO> {
    private final EmpresaRepository repository;

    public EmpresaService(EmpresaRepository repository) {
        this.repository = repository;
    }

    @Override
    protected JpaRepository<Empresa, Long> getRepository() {
        return repository;
    }

    @Override
    protected EmpresaDTO mapEntityToDTO(Empresa entity) {
        return new EmpresaDTO(entity.getCnpj(), entity.getRazaoSocial(), entity.getRelatorio());
    }

    @Override
    protected List<EmpresaDTO> mapListEntitiesToDTOs(List<Empresa> entities) {
        return entities.stream().map(this::mapEntityToDTO).collect(Collectors.toList());
    }

    @Override
    protected Empresa mapDTOtoEntity(EmpresaDTO dto) {
        return new Empresa(dto.cnpj(), dto.razaoSocial(), dto.relatorio());
    }
}
