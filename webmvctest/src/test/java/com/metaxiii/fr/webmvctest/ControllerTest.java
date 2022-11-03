package com.metaxiii.fr.webmvctest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Controller.class)
class ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void sayHello() throws Exception {
        mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
    }
}
