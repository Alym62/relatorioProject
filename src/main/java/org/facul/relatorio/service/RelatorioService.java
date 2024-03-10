package org.facul.relatorio.service;

import org.facul.relatorio.domain.Relatorio;
import org.facul.relatorio.dto.request.RelatorioRequestDTO;
import org.facul.relatorio.dto.response.RelatorioResponseDTO;
import org.facul.relatorio.repository.RelatorioRepository;
import org.facul.relatorio.service.base.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RelatorioService extends BaseService<Relatorio, Long, RelatorioRequestDTO, RelatorioResponseDTO> {
    private final RelatorioRepository repository;

    public RelatorioService(RelatorioRepository repository) {
        this.repository = repository;
    }

    @Override
    protected JpaRepository<Relatorio, Long> getRepository() {
        return repository;
    }

    @Override
    protected void mapUpdateDTORequestToEntity(Relatorio entity, RelatorioRequestDTO relatorioRequestDTO) {
        entity.setDataDoPeriodoDeAnalise(relatorioRequestDTO.dataDoPeriodoDeAnalise());
        entity.setResumo(relatorioRequestDTO.resumo());
        entity.setReceitaTotal(relatorioRequestDTO.receitaTotal());
        entity.setTotalDeVendas(relatorioRequestDTO.totalDeVendas());
        entity.setVendas(relatorioRequestDTO.vendas());
        entity.setEmpresa(relatorioRequestDTO.empresa());
    }

    @Override
    protected RelatorioRequestDTO mapEntityToDTORequest(Relatorio entity) {
        return new RelatorioRequestDTO(entity.getDataDoPeriodoDeAnalise(), entity.getResumo(), entity.getReceitaTotal(), entity.getTotalDeVendas(), entity.getVendas(), entity.getEmpresa());
    }

    @Override
    protected RelatorioResponseDTO mapEntityToDTOResponse(Relatorio entity) {
        return new RelatorioResponseDTO(entity.getId(), entity.getDataDoPeriodoDeAnalise(), entity.getResumo(), entity.getReceitaTotal(), entity.getTotalDeVendas());
    }

    @Override
    protected List<RelatorioResponseDTO> mapListEntitiesToDTOs(List<Relatorio> entities) {
        return entities.stream().map(this::mapEntityToDTOResponse).collect(Collectors.toList());
    }

    @Override
    protected Relatorio mapDTORequestToEntity(RelatorioRequestDTO relatorioRequestDTO) {
        return new Relatorio(relatorioRequestDTO.dataDoPeriodoDeAnalise(), relatorioRequestDTO.resumo(), relatorioRequestDTO.receitaTotal(), relatorioRequestDTO.totalDeVendas(), relatorioRequestDTO.vendas(), relatorioRequestDTO.empresa());
    }
}
