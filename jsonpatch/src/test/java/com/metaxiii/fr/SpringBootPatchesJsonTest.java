package com.metaxiii.fr;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.metaxiii.fr.controller.HeroEntity;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class SpringBootPatchesJsonTest {

  private final ObjectMapper mapper = new ObjectMapper();

  @Autowired
  private MockMvc mockMvc;

  @Test
  void SpringBootPatchesJson() {
    assertDoesNotThrow(() -> SpringBootPatchesJson.main(new String[] {}));
  }

  @Test
  void itShouldGetAllHeroes() throws Exception {
    final var result = mockMvc
      .perform(get("/"))
      .andExpect(status().isOk())
      .andReturn()
      .getResponse()
      .getContentAsString();
    System.out.println(result);
    final var heroes = mapper.readValue(result, new TypeReference<List<HeroEntity>>() {});
    assertEquals(2, heroes.size());
    assertEquals(1, heroes.get(0).getId());
    assertEquals("Superman", heroes.get(0).getName());
    assertEquals(2, heroes.get(1).getId());
    assertEquals("Batman", heroes.get(1).getName());
  }

  @Test
  void itShouldAddSupermanWeakness() throws Exception {
    final var result = mockMvc
      .perform(
        patch("/")
          .contentType("application/json-patch+json")
          .content(
            """
              [{ "op": "add", "path": "/powers/weaknesses/-", "value": "Magic" }]
            """
          )
      )
      .andExpect(status().isOk())
      .andReturn()
      .getResponse()
      .getContentAsString();
    System.out.println(result);
  }

  @Test
  void itShouldAddSupermanWeaknessButAtZeroIndexes() throws Exception {
    final var result = mockMvc
      .perform(
        patch("/")
          .contentType("application/json-patch+json")
          .content(
            """
              [{ "op": "add", "path": "/powers/weaknesses/0", "value": "Magic" }]
            """
          )
      )
      .andExpect(status().isOk())
      .andReturn()
      .getResponse()
      .getContentAsString();
    System.out.println(result);
  }

  @Test
  void itShouldRemoveSupermanWeakness() throws Exception {
    final var result = mockMvc
      .perform(
        patch("/")
          .contentType("application/json-patch+json")
          .content(
            """
              [{ "op": "remove", "path": "/powers/weaknesses" }]
            """
          )
      )
      .andExpect(status().isOk())
      .andReturn()
      .getResponse()
      .getContentAsString();
    System.out.println(result);
  }

  @Test
  void itShouldUpdateSupermanWeakness() throws Exception {
    final var result = mockMvc
      .perform(
        patch("/")
          .contentType("application/json-patch+json")
          .content(
            """
              [{ "op": "replace", "path": "/powers/weaknesses", "value": "Batman" }]
            """
          )
      )
      .andExpect(status().isOk())
      .andReturn()
      .getResponse()
      .getContentAsString();
    System.out.println(result);
  }

  @Test
  void itShouldCopySupermanWeakness() throws Exception {
    final var result = mockMvc
      .perform(
        patch("/")
          .contentType("application/json-patch+json")
          .content(
            """
              [{ "op": "copy", "from": "/powers/weaknesses/1", "path": "/powers/weaknesses/-" }]
            """
          )
      )
      .andExpect(status().isOk())
      .andReturn()
      .getResponse()
      .getContentAsString();
    System.out.println(result);
  }
}
