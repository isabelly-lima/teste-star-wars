package com.example.testestarwars.dto;

import com.example.testestarwars.model.PlanetTerrainEnum;
import lombok.Data;

import java.util.List;

@Data
public class ApiPlanetInfoDto {
    private String name;
    private String rotationPeriod;
    private String orbitalPeriod;
    private String diameter;
    private String climate;
    private String gravity;
    private PlanetTerrainEnum terrain;
    private String surfaceWater;
    private String population;
    private List<String> residents;
    private List<String> films;
    private String created;
    private String edited;
    private String url;
}
