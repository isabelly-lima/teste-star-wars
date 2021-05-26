package com.example.testestarwars.controller;

import com.example.testestarwars.converter.PlanetConverter;
import com.example.testestarwars.dto.PlanetDto;
import com.example.testestarwars.dto.PlanetInputDto;
import com.example.testestarwars.exceptions.PlanetNotFoundException;
import com.example.testestarwars.model.Planet;
import com.example.testestarwars.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

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
        List<PlanetDto> planetDtos = planetConverter.toPlanetDto(planets);
        if (Objects.isNull(planetDtos) || planetDtos.size() <= 0) {
            throw new PlanetNotFoundException("Não há nenhum planeta cadastrado no banco de dados. " +
                    "Por favor, insira um planeta para somente depois poder listá-lo!");
        }
        return planetDtos;
    }

    @GetMapping(value ="/{planetId}/id/search")
    public PlanetDto listPlanetById(@PathVariable("planetId") String planetId) {
        Planet planetById = planetService.getPlanetById(planetId);
        PlanetDto planetDto = planetConverter.toPlanetDto(planetById);
        if (Objects.isNull(planetDto)) {
            throw new PlanetNotFoundException("O planeta buscado não se encontra no banco de dados. " +
                    "Por favor, insira um id presente no banco de dados!");
        }
        return planetDto;
    }

    @GetMapping(value ="/{planetName}/name/search")
    public PlanetDto listPlanetByName(@PathVariable("planetName") String planetName) {
        Planet planetByName = planetService.getPlanetByName(planetName);
        PlanetDto planetDto = planetConverter.toPlanetDto(planetByName);
        if (Objects.isNull(planetDto)) {
            throw new PlanetNotFoundException("O planeta buscado não se encontra no banco de dados. " +
                    "Por favor, insira um nome presente no banco de dados!");
        }
        return planetDto;
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
