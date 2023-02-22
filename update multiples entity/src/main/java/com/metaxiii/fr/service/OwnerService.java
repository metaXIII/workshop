package com.metaxiii.fr.service;

import com.metaxiii.fr.entity.OwnerEntity;
import com.metaxiii.fr.DTO.OwnerEntityProjectionDTO;

import java.util.List;

public interface OwnerService {
    List<OwnerEntity> findAll();

    OwnerEntityProjectionDTO findById(long id);

    OwnerEntity partialSave(OwnerEntityProjectionDTO save);
}
