package com.example.testestarwars.dto;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
public class ApiPlanetInfoDto {
    private String name;
    private String rotationPeriod;
    private String orbitalPeriod;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String surfaceWater;
    private String population;
    private List<String> residents;
    private List<String> films;
    private String created;
    private String edited;
    private String url;

    public List<String> getFilms() {
        return this.films;
    }
}
