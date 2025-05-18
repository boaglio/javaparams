package com.javaparams.api;

import com.javaparams.repo.ParameterRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Objects;

@RestController
@RequestMapping("/api/parameter")
public class ParameterLikesApi {

    private final ParameterRepository repository;

    public ParameterLikesApi(ParameterRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/{id}/like")
    public ResponseEntity<Long> likeParameter(@PathVariable Long id, Principal principal) {

        if (principal == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return repository.findById(id)
            .map(param -> {
                if (Objects.isNull(param.getTotalLikes())) param.setTotalLikes(0L);
                param.setTotalLikes(param.getTotalLikes() + 1);
                repository.save(param);
                return ResponseEntity.ok(param.getTotalLikes());
            })
            .orElse(ResponseEntity.notFound().build());
    }
}
