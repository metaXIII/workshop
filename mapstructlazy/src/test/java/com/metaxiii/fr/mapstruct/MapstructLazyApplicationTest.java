package com.metaxiii.fr.mapstruct;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.metaxiii.fr.mapstruct.model.Utility;
import com.metaxiii.fr.mapstruct.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class MapstructLazyApplicationTest {
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ItemRepository itemRepository;

  @Test
  void contextLoads() {
    assertDoesNotThrow(() -> MapstructLazyApplication.main(new String[] {}));
  }

  @Test
  void itShouldCallUpdateWithEntityReturned() throws Exception {
    mockMvc.perform(patch("/item/1")).andDo(print()).andExpect(status().isOk());
    final var all = itemRepository.findAll();
    final var item = all.get(0);
    assertEquals(12.24, item.getValue());
  }

  @Test
  void itShouldCallUpdateWithEntityReturningVoid() throws Exception {
    mockMvc.perform(patch("/item/2")).andDo(print()).andExpect(status().isOk());
    final var all = itemRepository.findAll();
    final var item = all.get(0);
    assertEquals(24.12, item.getValue());
  }

  @Test
  void itShouldCallMapper() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    final var mvcResult = mockMvc.perform(get("/item/3")).andDo(print()).andExpect(status().isOk()).andReturn();
    final var utility = mapper.readValue(mvcResult.getResponse().getContentAsString(), Utility.class);
    assertNotNull(utility.getItem());
  }

  @Test
  void itShouldCallLazyMapper() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    final var mvcResult = mockMvc.perform(get("/item/4")).andDo(print()).andExpect(status().isOk()).andReturn();
    final var utility = mapper.readValue(mvcResult.getResponse().getContentAsString(), Utility.class);
    assertNull(utility.getItem());
  }
}
