package org.facul.relatorio.service;

import org.facul.relatorio.domain.Empresa;
import org.facul.relatorio.domain.Relatorio;
import org.facul.relatorio.dto.request.EmpresaRequestDTO;
import org.facul.relatorio.dto.response.EmpresaResponseDTO;
import org.facul.relatorio.repository.EmpresaRepository;
import org.facul.relatorio.repository.RelatorioRepository;
import org.facul.relatorio.service.base.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaService extends BaseService<Empresa, Long, EmpresaRequestDTO, EmpresaResponseDTO> {
    private final EmpresaRepository repository;

    private final RelatorioRepository relatorioRepository;

    public EmpresaService(EmpresaRepository repository, RelatorioRepository relatorioRepository) {
        this.repository = repository;
        this.relatorioRepository = relatorioRepository;
    }

    public void vincularRelatorio(Long idRelatorio, Long idEmpresa) {
        Empresa empresa = repository.findById(idEmpresa)
                .orElseThrow(() -> new RuntimeException("Não existe uma empresa com esse id: " + idEmpresa));

        Relatorio relatorio = relatorioRepository.findById(idRelatorio)
                .orElseThrow(() -> new RuntimeException("Não existe um relatório com esse id: " + idRelatorio));

        relatorio.setEmpresa(empresa);

        relatorioRepository.save(relatorio);
    }

    @Override
    protected JpaRepository<Empresa, Long> getRepository() {
        return repository;
    }

    @Override
    protected void mapUpdateDTORequestToEntity(Empresa entity, EmpresaRequestDTO dto) {
        entity.setCnpj(dto.cnpj());
        entity.setRazaoSocial(dto.razaoSocial());
        entity.setRelatorio(dto.relatorio());
    }

    @Override
    protected EmpresaRequestDTO mapEntityToDTORequest(Empresa entity) {
        return new EmpresaRequestDTO(entity.getCnpj(), entity.getRazaoSocial(), entity.getRelatorio());
    }

    @Override
    protected EmpresaResponseDTO mapEntityToDTOResponse(Empresa entity) {
        return new EmpresaResponseDTO(entity.getId(), entity.getCnpj(), entity.getRazaoSocial());
    }

    @Override
    protected List<EmpresaResponseDTO> mapListEntitiesToDTOs(List<Empresa> entities) {
        return entities.stream().map(this::mapEntityToDTOResponse).collect(Collectors.toList());
    }

    @Override
    protected Empresa mapDTORequestToEntity(EmpresaRequestDTO dto) {
        return new Empresa(dto.cnpj(), dto.razaoSocial(), dto.relatorio());
    }
}
