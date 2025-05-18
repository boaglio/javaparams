package com.javaparams.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaparams.domain.Vote;
 
public interface VoteRepository extends JpaRepository<Vote, Long> {

}
