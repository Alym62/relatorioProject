package org.facul.relatorio.service;

import org.facul.relatorio.domain.Venda;
import org.facul.relatorio.dto.request.VendaRequestDTO;
import org.facul.relatorio.dto.response.VendaResponseDTO;
import org.facul.relatorio.repository.VendaRepository;
import org.facul.relatorio.service.base.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendaService extends BaseService<Venda, Long, VendaRequestDTO, VendaResponseDTO> {
    private final VendaRepository repository;

    public VendaService(VendaRepository repository) {
        this.repository = repository;
    }

    @Override
    protected JpaRepository<Venda, Long> getRepository() {
        return repository;
    }

    @Override
    protected void mapUpdateDTORequestToEntity(Venda entity, VendaRequestDTO vendaRequestDTO) {
        entity.setDataDaVenda(vendaRequestDTO.dataDaVenda());
        entity.setNomeDoVendedor(vendaRequestDTO.nomeDoVendedor());
        entity.setProdutos(vendaRequestDTO.produtos());
        entity.setRelatorio(vendaRequestDTO.relatorio());
    }

    @Override
    protected VendaRequestDTO mapEntityToDTORequest(Venda entity) {
        return new VendaRequestDTO(entity.getDataDaVenda(), entity.getNomeDoVendedor(), entity.getProdutos(), entity.getRelatorio());
    }

    @Override
    protected VendaResponseDTO mapEntityToDTOResponse(Venda entity) {
        return new VendaResponseDTO(entity.getId(), entity.getDataDaVenda(), entity.getNomeDoVendedor());
    }

    @Override
    protected List<VendaResponseDTO> mapListEntitiesToDTOs(List<Venda> entities) {
        return entities.stream().map(this::mapEntityToDTOResponse).collect(Collectors.toList());
    }

    @Override
    protected Venda mapDTORequestToEntity(VendaRequestDTO vendaRequestDTO) {
        return new Venda(vendaRequestDTO.dataDaVenda(), vendaRequestDTO.nomeDoVendedor(), vendaRequestDTO.produtos(), vendaRequestDTO.relatorio());
    }
}
