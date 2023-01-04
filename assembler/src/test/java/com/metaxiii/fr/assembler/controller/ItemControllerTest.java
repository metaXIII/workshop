package com.metaxiii.fr.assembler.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.metaxiii.fr.assembler.dto.ItemInput;
import com.metaxiii.fr.assembler.dto.NameInputDTO;
import com.metaxiii.fr.assembler.entity.ItemEntity;
import com.metaxiii.fr.assembler.model.ItemModel;
import com.metaxiii.fr.assembler.model.SecondModelAskedByEmmanuel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper;

    @BeforeEach
    void init() {
        this.mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    @Test
    void Wrong_solution() throws Exception {
        final var result = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/"))
                .andDo(print())
                .andExpect(status()
                        .isOk())
                .andReturn();
        final var list = mapper.readValue(result.getResponse().getContentAsString(),
                new TypeReference<List<ItemEntity>>() {
                });
        assertEquals(6, list.size());
    }


    @Test
    void solution_at_path1() throws Exception {
        final var result = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/1"))
                .andDo(print())
                .andExpect(status()
                        .isOk())
                .andReturn();
        final var list = mapper.readValue(result.getResponse().getContentAsString(),
                new TypeReference<List<ItemModel>>() {
                });
        assertEquals(6, list.size());
    }

    @Test
    void solution_at_path2() throws Exception {
        final var result = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/2"))
                .andDo(print())
                .andExpect(status()
                        .isOk())
                .andReturn();
        final var list = mapper.readValue(result.getResponse().getContentAsString(),
                new TypeReference<List<SecondModelAskedByEmmanuel>>() {
                });
        assertEquals(6, list.size());
    }

    @Test
    void solutionPost() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.post("/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJson(ItemInput.builder().name("ok").price(12.24).build())))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void solutionPatch() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.patch("/")
                        .content(asJson(NameInputDTO.builder().name("ok").build()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    private String asJson(final Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }
}
