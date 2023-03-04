package com.metaxiii.fr.fakefeign.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(HelloController.class)
@AutoConfigureMockMvc
class HelloControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  void hello() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/")).andDo(print()).andExpect(status().isOk());
  }

  @Test
  void showException() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/1")).andDo(print()).andExpect(status().isBadRequest());
    mockMvc.perform(MockMvcRequestBuilders.get("/2")).andDo(print()).andExpect(status().isBadRequest());
    mockMvc.perform(MockMvcRequestBuilders.get("/3")).andDo(print()).andExpect(status().isInternalServerError());
    mockMvc.perform(MockMvcRequestBuilders.get("/4")).andDo(print()).andExpect(status().isOk());
  }
}
