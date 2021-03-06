package com.example.testestarwars.repository;

import com.example.testestarwars.model.Planet;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanetRepository extends MongoRepository<Planet, Integer> {
    @Query(value = "{'_id':'?0'}")
    Planet findPlanetByPlanetId(String planetId);

    Planet findPlanetsByName(String name);

    List<Planet> findAll();
}
