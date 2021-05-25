package com.example.testestarwars.service;

import com.example.testestarwars.dto.ApiPlanetInfoDto;
import com.example.testestarwars.dto.PlanetDto;
import com.example.testestarwars.dto.PlanetInputDto;
import com.example.testestarwars.dto.SwApiResponseDto;
import com.example.testestarwars.model.Planet;
import com.example.testestarwars.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanetService {
    @Autowired
    private PlanetRepository planetRepository;


    @Transactional(readOnly = true)
    public List<Planet> getPlanets() {
        return planetRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Planet getPlanetById(String planetId) {
        return planetRepository.findPlanetByPlanetId(planetId);
    }

    @Transactional(readOnly = true)
    public Planet getPlanetByName(String name) {
        return planetRepository.findPlanetsByName(name);
    }

    @Transactional
    public void createPlanet(PlanetInputDto planetInputDto) {
        final RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<SwApiResponseDto> entity = restTemplate
                .getForEntity("https://swapi.dev/api/planets", SwApiResponseDto.class);

        SwApiResponseDto swApiResponseDto = entity.getBody();

        List<SwApiResponseDto> swApiResponseDtoList = new ArrayList<>();

        swApiResponseDtoList.add(swApiResponseDto);

        String next = swApiResponseDto.getNext() != null ? swApiResponseDto.getNext() : null;

        while (next != null && !next.isEmpty()) {
            ResponseEntity<SwApiResponseDto> nextSwApiDto = restTemplate
                    .getForEntity(next, SwApiResponseDto.class);

            SwApiResponseDto nextSwApiResponseDto = entity.getBody();

            if (nextSwApiResponseDto.getNext() != null && !nextSwApiResponseDto.getNext().isEmpty()) {
                next = nextSwApiResponseDto.getNext();
            }

            swApiResponseDtoList.add(nextSwApiResponseDto);
        }

        int numberOfFilmAppearances = 0;

        for (SwApiResponseDto apiResponseDto : swApiResponseDtoList) {
            for (ApiPlanetInfoDto result : apiResponseDto.getResults()) {
                if (planetInputDto.getName().equalsIgnoreCase(result.getName())) {
                    numberOfFilmAppearances = result.getFilms().size();
                }
            }
        }

        Planet planet = new Planet();
        planet.setClimate(planetInputDto.getClimate());
        planet.setName(planetInputDto.getName());
        planet.setPlanetTerrainEnum(planetInputDto.getPlanetTerrainEnum());
        planet.setNumberOfMovieAppearances(numberOfFilmAppearances);
        planetRepository.save(planet);
    }

    @Transactional
    public void deletePlanetById(String planetId) {
        Planet planet = planetRepository.findPlanetByPlanetId(planetId);
        planetRepository.delete(planet);
    }
}
