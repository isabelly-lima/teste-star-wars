package com.example.testestarwars.repository;

import com.example.testestarwars.dto.PlanetDto;
import com.example.testestarwars.model.Planet;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanetRepository extends MongoRepository<Planet, Integer> {
    @Query("{planetId:'?0'}")
    Planet findPlanetByPlanetId(String planetId);

    Planet findPlanetsByName(String name);

//    @Query(value = "SELECT * FROM planet", nativeQuery = true)
//    List<PlanetDto> getAllPlanets();

    List<Planet> findAll();
}
