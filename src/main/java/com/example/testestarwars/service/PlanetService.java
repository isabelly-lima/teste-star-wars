package com.example.testestarwars.service;

import com.example.testestarwars.dto.PlanetDto;
import com.example.testestarwars.dto.PlanetInputDto;
import com.example.testestarwars.model.Planet;
import com.example.testestarwars.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlanetService {
    @Autowired
    private PlanetRepository planetRepository;


    @Transactional(readOnly = true)
    public List<PlanetDto> getPlanets() {
        return planetRepository.getAllPlanets();
    }

    @Transactional(readOnly = true)
    public PlanetDto getPlanetDtoById(Integer planetId) {
        Planet planet = planetRepository.getById(planetId);
        return planetRepository.findPlanetByPlanetId(planet);
    }

    @Transactional(readOnly = true)
    public PlanetDto getPlanetDtoByName(String name) {
        return planetRepository.findPlanetsByName(name);
    }

    @Transactional
    public void createPlanet(PlanetInputDto planetInputDto) {
        Planet planet = new Planet();
        planet.setClimate(planetInputDto.getClimate());
        planet.setName(planetInputDto.getName());
        planet.setPlanetTerrainEnum(planetInputDto.getPlanetTerrainEnum());
        planetRepository.save(planet);
    }

    @Transactional
    public void deletePlanetById(Integer planetId) {
        Planet planet = planetRepository.getById(planetId);
        planetRepository.delete(planet);
    }
}
