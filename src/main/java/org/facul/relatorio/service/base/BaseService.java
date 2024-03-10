package org.facul.relatorio.service.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public abstract class BaseService<T, ID, DTORequest, DTOResponse> {
    protected abstract JpaRepository<T, ID> getRepository();

    public List<DTOResponse> buscarPorTodos() {
        List<T> entities = getRepository().findAll();
        return mapListEntitiesToDTOs(entities);
    }

    public Optional<DTOResponse> buscarPorId(ID id) {
        return getRepository().findById(id).map(this::mapEntityToDTOResponse);
    }

    public DTORequest salvar(DTORequest dto) {
        T entity = mapDTORequestToEntity(dto);
        return mapEntityToDTORequest(getRepository().save(entity));
    }

    public DTORequest update(ID id, DTORequest dto) {
        Optional<T> optionalEntity = getRepository().findById(id);

        if (optionalEntity.isPresent()) {
            T entityExists = optionalEntity.get();
            mapUpdateDTORequestToEntity(entityExists, dto);
            entityExists = getRepository().save(entityExists);
            return mapEntityToDTORequest(entityExists);
        } else {
            return null;
        }
    }

    public void deletar (ID id) {
        getRepository().deleteById(id);
    }

    protected abstract void mapUpdateDTORequestToEntity(T entity, DTORequest dto);

    protected abstract DTOResponse mapEntityToDTOResponse(T entity);

    protected abstract DTORequest mapEntityToDTORequest(T entity);

    protected abstract List<DTOResponse> mapListEntitiesToDTOs(List<T> entities);

    protected abstract T mapDTORequestToEntity(DTORequest dto);
}
