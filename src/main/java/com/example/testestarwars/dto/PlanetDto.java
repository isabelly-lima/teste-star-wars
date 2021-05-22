package com.example.testestarwars.dto;

import com.example.testestarwars.model.PlanetTerrainEnum;
import lombok.Data;

@Data
public class PlanetDto {
    private Integer planetId;
    private String name;
    private String climate;
    private PlanetTerrainEnum planetTerrainEnum;
}
