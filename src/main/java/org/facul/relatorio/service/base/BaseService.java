package org.facul.relatorio.service.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public abstract class BaseService<T, ID, DTO> {
    protected abstract JpaRepository<T, ID> getRepository();

    public List<DTO> buscarPorTodos() {
        List<T> entities = getRepository().findAll();
        return mapListEntitiesToDTOs(entities);
    }

    public Optional<DTO> buscarPorId(ID id) {
        return getRepository().findById(id).map(this::mapEntityToDTO);
    }

    public DTO salvar(DTO dto) {
        T entity = mapDTOtoEntity(dto);
        return mapEntityToDTO(getRepository().save(entity));
    }

    public DTO update(ID id, DTO dto) {
        Optional<T> optionalEntity = getRepository().findById(id);

        if (optionalEntity.isPresent()) {
            T entity = mapDTOtoEntity(dto);
            entity = getRepository().save(entity);
            return mapEntityToDTO(entity);
        } else {
            return null;
        }
    }

    public void deletar (ID id) {
        getRepository().deleteById(id);
    }

    protected abstract DTO mapEntityToDTO(T entity);

    protected abstract List<DTO> mapListEntitiesToDTOs(List<T> entities);

    protected abstract T mapDTOtoEntity(DTO dto);
}
