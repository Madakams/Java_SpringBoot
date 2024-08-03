package com.dnapass.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dnapass.training.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
