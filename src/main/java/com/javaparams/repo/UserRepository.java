package com.javaparams.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaparams.domain.User;
 
public interface UserRepository extends JpaRepository<User, Long> {

}
