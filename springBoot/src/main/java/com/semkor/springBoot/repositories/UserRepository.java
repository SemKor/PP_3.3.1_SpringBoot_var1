package com.semkor.springBoot.repositories;

import com.semkor.springBoot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
}
