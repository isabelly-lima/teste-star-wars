package com.example.testestarwars.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PlanetInputDto {
    @NotEmpty
    private String name;

    @NotEmpty
    private String climate;

    @NotEmpty
    private String terrain;

    public String getClimate() {
        return this.climate;
    }

    public String getName() {
        return this.name;
    }

    public String getTerrain () {
        return this.terrain;
    }
}
