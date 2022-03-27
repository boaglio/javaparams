package com.javaparams.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.javaparams.domain.Parameter;
import com.javaparams.repo.ParameterRepository;

@RestController
@RequestMapping("/api/params")
public class ParameterAPI {

    @Autowired
    private ParameterRepository repository;

    @GetMapping("/list")
    public List<Parameter> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Parameter getParameter(@PathVariable Long id) {

        Optional<Parameter> parameterOpt = repository.findById(id);
        if (parameterOpt.isPresent()) {
            return parameterOpt.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/")
    public Parameter newParameter(@RequestBody Parameter newParameter) {
        return newParameter;
    }

}
