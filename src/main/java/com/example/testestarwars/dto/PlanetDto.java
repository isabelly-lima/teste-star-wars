package com.example.testestarwars.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PlanetDto implements Serializable {
    private String id;
    private String name;
    private String climate;
    private String terrain;
    private Integer numberOfMovieAppearances;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public void setNumberOfMovieAppearances(Integer numberOfMovieAppearances) {
        this.numberOfMovieAppearances = numberOfMovieAppearances;
    }
}
