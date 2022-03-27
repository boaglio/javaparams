package com.javaparams.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaparams.domain.Parameter;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Long> {

}
