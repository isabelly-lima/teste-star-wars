package com.example.testestarwars.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PlanetDto implements Serializable {
    private String id;
    private String name;
    private String climate;
    private String terrain;
    private Integer numberOfMovieAppearances;
}
