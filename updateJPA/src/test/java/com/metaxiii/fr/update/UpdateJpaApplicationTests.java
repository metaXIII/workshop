package com.metaxiii.fr.update;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.metaxiii.fr.update.repository.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class UpdateJpaApplicationTests {
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ItemRepository itemRepository;

  @Test
  void contextLoads() {
    assertDoesNotThrow(() -> UpdateJpaApplication.main(new String[] {}));
  }

  @Test
  void itShouldCallUpdateWithEntityReturned() throws Exception {
    mockMvc.perform(patch("/item/1")).andDo(print()).andExpect(status().isOk());
    final var all = itemRepository.findAll();
    final var item = all.get(0);
    Assertions.assertEquals(12.24, item.getValue());
  }

  @Test
  void itShouldCallUpdateWithEntityReturningVoid() throws Exception {
    mockMvc.perform(patch("/item/2")).andDo(print()).andExpect(status().isOk());
    final var all = itemRepository.findAll();
    final var item = all.get(0);
    Assertions.assertEquals(24.12, item.getValue());
  }
}
