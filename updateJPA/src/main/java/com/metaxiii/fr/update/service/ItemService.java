package com.metaxiii.fr.update.service;

import com.metaxiii.fr.update.entity.Item;

public interface ItemService {
  Item updateNameAndValueByItemId(String name, double value, long l);

  void updateNameAndValueByItemIdReturningVoid(String name, double value, long l);
}
