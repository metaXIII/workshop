package com.metaxiii.fr.bettertesting.service.impl;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

import com.metaxiii.fr.bettertesting.mapper.ItemMapper;
import com.metaxiii.fr.bettertesting.repository.ItemRepository;
import com.metaxiii.fr.bettertesting.service.ItemService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
class ItemServiceImplTest {

  @InjectMocks
  private ItemServiceImpl itemService;

  @Mock
  private ItemRepository itemRepository;

  @Mock
  private ItemMapper itemMapper;

  @Test
  void itShouldShopAllItems() {
    when(itemRepository.findAll()).thenReturn(List.of());
    assertDoesNotThrow(() -> itemService.shopAllItems());
  }
}
