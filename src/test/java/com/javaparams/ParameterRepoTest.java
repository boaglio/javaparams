package com.javaparams;

import com.javaparams.repo.ParameterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ParameterRepoTest {

    @Autowired
    ParameterRepository parameterRepository;

    @Test
    void testParameterCount() {

        var totalParams = parameterRepository.count();

        assertEquals(10,totalParams);

    }

}
