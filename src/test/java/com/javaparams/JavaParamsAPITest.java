package com.javaparams;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class JavaParamsAPITest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getErrorForProtectedAPI() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/parameter/top")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().is3xxRedirection());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/parameter/1/like")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is3xxRedirection());

    }

}
