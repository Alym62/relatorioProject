package org.facul.relatorio.service;

import org.facul.relatorio.domain.Produto;
import org.facul.relatorio.dto.request.ProdutoRequestDTO;
import org.facul.relatorio.dto.response.ProdutoResponseDTO;
import org.facul.relatorio.repository.ProdutoRepository;
import org.facul.relatorio.service.base.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService extends BaseService<Produto, Long, ProdutoRequestDTO, ProdutoResponseDTO> {
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    protected JpaRepository<Produto, Long> getRepository() {
        return repository;
    }

    @Override
    protected void mapUpdateDTORequestToEntity(Produto entity, ProdutoRequestDTO produtoRequestDTO) {
        entity.setNomeDoProduto(produtoRequestDTO.nomeDoProduto());
        entity.setDescricao(produtoRequestDTO.descricao());
        entity.setValorDoProduto(produtoRequestDTO.valorDoProduto());
        entity.setVenda(produtoRequestDTO.venda());
        entity.setTipoProduto(produtoRequestDTO.tipoProduto());
    }

    @Override
    protected ProdutoRequestDTO mapEntityToDTORequest(Produto entity) {
        return new ProdutoRequestDTO(entity.getNomeDoProduto(), entity.getDescricao(), entity.getValorDoProduto(), entity.getVenda(), entity.getTipoProduto());
    }

    @Override
    protected ProdutoResponseDTO mapEntityToDTOResponse(Produto entity) {
        return new ProdutoResponseDTO(entity.getId(), entity.getNomeDoProduto(), entity.getDescricao(), entity.getValorDoProduto(), entity.getTipoProduto());
    }

    @Override
    protected List<ProdutoResponseDTO> mapListEntitiesToDTOs(List<Produto> entities) {
        return entities.stream().map(this::mapEntityToDTOResponse).collect(Collectors.toList());
    }

    @Override
    protected Produto mapDTORequestToEntity(ProdutoRequestDTO produtoRequestDTO) {
        return new Produto(produtoRequestDTO.nomeDoProduto(), produtoRequestDTO.descricao(), produtoRequestDTO.valorDoProduto(), produtoRequestDTO.venda(), produtoRequestDTO.tipoProduto());
    }
}
