package com.javaparams;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.javaparams.api.ParameterAPI;
import com.javaparams.domain.Parameter;
import com.javaparams.repo.ParameterRepository;

@WebMvcTest(ParameterAPI.class)
public class JavaParamsAPITest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ParameterRepository repository;

    Parameter PARAM_1 = new Parameter(1l, "-Xmn",
            "Sets the initial and maximum size (in bytes) of the heap for the young generation (nursery) in the generational collectors");
    Parameter PARAM_2 = new Parameter(2l, "-Xms", "Sets the minimum and the initial size (in bytes) of the heap");
    Parameter PARAM_3 = new Parameter(3l, "-Xmx", "Specifies the maximum size (in bytes) of the heap");
    Parameter PARAM_4 = new Parameter(4l, "-Xnoclassgc", "Disables garbage collection (GC) of classes");

    @Test
    public void getAllJavaParams() throws Exception {

        List<Parameter> records = new ArrayList<>(Arrays.asList(PARAM_1, PARAM_2, PARAM_3, PARAM_4));

        Mockito.when(repository.findAll()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/params/list").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$[1].name", is("-Xms")));

    }

}
