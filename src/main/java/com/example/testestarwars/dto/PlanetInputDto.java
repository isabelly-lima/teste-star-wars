package com.example.testestarwars.dto;

import com.example.testestarwars.model.PlanetTerrainEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanetInputDto {
    @NotEmpty
    private String name;

    @NotEmpty
    private String climate;

    @NotEmpty
    private PlanetTerrainEnum planetTerrainEnum;
}
