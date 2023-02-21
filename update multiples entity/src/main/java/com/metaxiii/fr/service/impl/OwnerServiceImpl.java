package com.metaxiii.fr.service.impl;

import com.metaxiii.fr.entity.OwnerEntity;
import com.metaxiii.fr.DTO.OwnerEntityProjectionDTO;
import com.metaxiii.fr.mapper.OwnerMapper;
import com.metaxiii.fr.repository.OwnerRepository;
import com.metaxiii.fr.service.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository repository;
    private final OwnerMapper mapper;

    @Override
    public List<OwnerEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public OwnerEntityProjectionDTO findById(long id) {
        return repository.findById(id, OwnerEntityProjectionDTO.class);
    }

    @Override
    public OwnerEntity partialSave(final OwnerEntityProjectionDTO save) {
        final var entity = repository.getReferenceById(save.getId());
        mapper.toEntity(mapper.toDomain(save), entity);
        return repository.save(entity);
    }
}
