package com.metaxiii.fr.mapstruct.service;

import com.metaxiii.fr.mapstruct.entity.ItemEntity;
import com.metaxiii.fr.mapstruct.model.Utility;

public interface ItemService {
  ItemEntity updateNameAndValueByItemId(String name, double value, long l);

  void updateNameAndValueByItemIdReturningVoid(String name, double value, long l);

  Utility getMapper();

  Utility getMapperLazy();
}
