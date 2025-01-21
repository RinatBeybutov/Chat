package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    // HQL = hibernate query language
    @Query("SELECT u FROM UserEntity u join fetch u.city")
    List<UserEntity> findAllWithJoin();

    Optional<UserEntity> findByEmail(String email);
}
