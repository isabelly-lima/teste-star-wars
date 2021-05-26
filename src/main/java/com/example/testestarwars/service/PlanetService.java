package com.example.testestarwars.service;

import com.example.testestarwars.dto.PlanetInputDto;
import com.example.testestarwars.dto.SwApiResponseDto;
import com.example.testestarwars.exceptions.PlanetAlreadyOnDatabaseException;
import com.example.testestarwars.exceptions.PlanetNotFoundException;
import com.example.testestarwars.model.Planet;
import com.example.testestarwars.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

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
        String firstLetter = name.substring(0,1);

        String firstLetterUpperCase = firstLetter.toUpperCase();

        String restOfPlanetName = name.substring(1);

        String planetName = firstLetterUpperCase + restOfPlanetName;

        return planetRepository.findPlanetsByName(planetName);
    }

    @Transactional
    public void createPlanet(PlanetInputDto planetInputDto) {
        RestTemplate restTemplate = new RestTemplate();

        String firstLetter = planetInputDto.getName().substring(0,1);

        String firstLetterUpperCase = firstLetter.toUpperCase();

        String restOfPlanetName = planetInputDto.getName().substring(1);

        String planetName = firstLetterUpperCase + restOfPlanetName;

        Planet planetsByName = planetRepository.findPlanetsByName(planetName);

        if (!Objects.isNull(planetsByName)) {
            throw new PlanetAlreadyOnDatabaseException("O planeta que você está tentando inserir já se encontra no " +
                    "banco de dados! Por favor, tente inserir o planeta novamente modificando os dados enviados.");
        }

        ResponseEntity<SwApiResponseDto> entity = restTemplate
                .exchange("https://swapi.dev/api/planets/?search="+planetName,
                        HttpMethod.GET,
                        null, SwApiResponseDto.class);

        SwApiResponseDto swApiResponseDto = entity.getBody();

        int numberOfFilmAppearances = 0;

        if (!swApiResponseDto.getResults().isEmpty()) {
            if (swApiResponseDto.getResults().get(0).getFilms().size() > 0) {
                numberOfFilmAppearances = swApiResponseDto.getResults().get(0).getFilms().size();
            }
        }

        Planet planet = new Planet();
        planet.setClimate(planetInputDto.getClimate());
        planet.setName(planetName);
        planet.setTerrain(planetInputDto.getTerrain());
        planet.setNumberOfMovieAppearances(numberOfFilmAppearances);
        planetRepository.save(planet);
    }

    @Transactional
    public void deletePlanetById(String planetId) {
        Planet planet = planetRepository.findPlanetByPlanetId(planetId);
        if (Objects.isNull(planet)) {
            throw new PlanetNotFoundException("O planeta que você está tentando deletar não se encontra no banco de dados. " +
                    "Por favor, insira um id presente no banco de dados!");
        }
        planetRepository.delete(planet);
    }
}
