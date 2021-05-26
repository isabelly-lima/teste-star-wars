package com.example.testestarwars.controller;

import com.example.testestarwars.converter.PlanetConverter;
import com.example.testestarwars.dto.PlanetDto;
import com.example.testestarwars.dto.PlanetInputDto;
import com.example.testestarwars.model.Planet;
import com.example.testestarwars.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping("/planet")
public class PlanetController {

    @Autowired
    private final PlanetService planetService;

    @Autowired
    private final PlanetConverter planetConverter;

    public PlanetController(PlanetService planetService, PlanetConverter planetConverter) {
        this.planetService = planetService;
        this.planetConverter = planetConverter;
    }

    @GetMapping(value ="/all")
    public List<PlanetDto> listPlanets() {
        List<Planet> planets = planetService.getPlanets();
        return planetConverter.toPlanetDto(planets);
    }

    @GetMapping(value ="/{planetId}/id/search")
    public PlanetDto listPlanetById(@PathVariable("planetId") String planetId) {
        Planet planetById = planetService.getPlanetById(planetId);
        return planetConverter.toPlanetDto(planetById);
    }

    @GetMapping(value ="/{planetName}/name/search")
    public PlanetDto listPlanetByName(@PathVariable("planetName") String planetName) {
        Planet planetByName = planetService.getPlanetByName(planetName);
        return planetConverter.toPlanetDto(planetByName);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPlanet(@Valid @RequestBody PlanetInputDto planetInputDto) {
        planetService.createPlanet(planetInputDto);
    }

    @DeleteMapping(value ="/{planetId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlanet(@PathVariable("planetId") String planetId) {
        planetService.deletePlanetById(planetId);
    }
}
