package com.example.testestarwars.repository;

import com.example.testestarwars.dto.PlanetDto;
import com.example.testestarwars.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Integer> {
    PlanetDto findPlanetByPlanetId(Planet planet);

    PlanetDto findPlanetsByName(String name);

    @Query(value = "SELECT * FROM planet", nativeQuery = true)
    List<PlanetDto> getAllPlanets();
}
