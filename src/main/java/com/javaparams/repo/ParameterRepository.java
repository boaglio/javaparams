package com.javaparams.repo;

import com.javaparams.domain.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ParameterRepository extends JpaRepository<Parameter, Long> {

    List<Parameter> findTop12ByOrderByTotalLikesDesc();

    List<Parameter> findByTotalLikesGreaterThan(int likes);

}
