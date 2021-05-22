package com.example.testestarwars.controller;

import com.example.testestarwars.dto.PlanetDto;
import com.example.testestarwars.dto.PlanetInputDto;
import com.example.testestarwars.service.PlanetService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/planet")
public class PlanetController {

    private final PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping
    public List<PlanetDto> listPlanets() {
        return planetService.getPlanets();
    }

    @GetMapping("/{planetId}")
    public PlanetDto listPlanetById(@PathVariable("planetId") Integer planetId) {
        return planetService.getPlanetDtoById(planetId);
    }

    @GetMapping("/{name}")
    public PlanetDto listPlanetByName(@PathVariable("name") String name) {
        return planetService.getPlanetDtoByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPlanet(@Valid @RequestBody PlanetInputDto planetInputDto) {
        planetService.createPlanet(planetInputDto);
    }

    @DeleteMapping("/{planetId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlanet(@PathVariable("planetId") Integer planetId) {
        planetService.deletePlanetById(planetId);
    }
}
