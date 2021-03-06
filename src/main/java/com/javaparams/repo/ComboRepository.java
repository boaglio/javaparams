package com.javaparams.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaparams.domain.Combo;

@Repository
public interface ComboRepository extends JpaRepository<Combo, Long> {

}
