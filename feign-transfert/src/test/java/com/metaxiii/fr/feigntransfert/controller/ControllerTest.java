package com.metaxiii.fr.feigntransfert.controller;

import com.metaxiii.fr.feigntransfert.service.client.FakeClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Controller.class)
@AutoConfigureMockMvc
class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    FakeClient fakeClient;

    @Test
    void hello() throws Exception {
        when(fakeClient.getHello()).thenReturn(ResponseEntity.ok(""));
        mockMvc.perform(MockMvcRequestBuilders.get("/")).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void sayError() throws Exception {
        when(fakeClient.getError("1")).thenReturn(ResponseEntity.ok(""));
        mockMvc.perform(MockMvcRequestBuilders.get("/1")).andDo(print())
                .andExpect(status().isOk());
    }
}
