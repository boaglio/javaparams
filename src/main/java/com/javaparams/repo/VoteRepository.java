package com.javaparams.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaparams.domain.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

}
