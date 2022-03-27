package com.javaparams;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.javaparams.config.DatabaseConfig;
import com.javaparams.domain.Parameter;
import com.javaparams.repo.ParameterRepository;

@ContextConfiguration(classes = { JavaparamsApplication.class, DatabaseConfig.class })
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JavaParamsLoadTest {

    @Autowired
    private ParameterRepository repository;

    @Test
    public void doParametersLoadTest() {

        repository.save(new Parameter(1l, "-Xmn",
                "Sets the initial and maximum size (in bytes) of the heap for the young generation (nursery) in the generational collectors"));
        repository.save(new Parameter(2l, "-Xms", "Sets the minimum and the initial size (in bytes) of the heap"));
        repository.save(new Parameter(3l, "-Xmx", "Specifies the maximum size (in bytes) of the heap"));
        repository.save(new Parameter(4l, "-Xnoclassgc", "Disables garbage collection (GC) of classes"));

    }

}
