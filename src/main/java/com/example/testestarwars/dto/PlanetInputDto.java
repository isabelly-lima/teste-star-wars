package com.example.testestarwars.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PlanetInputDto {
    @NotEmpty
    @NotNull
    @NotBlank
    private String name;

    @NotEmpty
    @NotNull
    @NotBlank
    private String climate;

    @NotEmpty
    @NotNull
    @NotBlank
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
