package com.example.demo.repository;

import com.example.demo.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<CityEntity, Integer> {

    Optional<CityEntity> findFirstByName(String cityName);
}
