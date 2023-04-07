package com.metaxiii.fr.service;

import com.metaxiii.fr.dto.OwnerEntityProjectionDTO;
import com.metaxiii.fr.entity.OwnerEntity;
import java.util.List;

public interface OwnerService {
  List<OwnerEntity> findAll();

  OwnerEntityProjectionDTO findById(long id);

  OwnerEntity partialSave(OwnerEntityProjectionDTO save);

  OwnerEntity save(OwnerEntityProjectionDTO projection);
}
