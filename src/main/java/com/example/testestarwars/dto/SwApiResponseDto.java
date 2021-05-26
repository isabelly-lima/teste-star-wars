package com.example.testestarwars.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class SwApiResponseDto {
    private Integer count;
    private String next;
    private String previous;
    private List<ApiPlanetInfoDto> results;

    public List<ApiPlanetInfoDto> getResults() {
        return this.results;
    }
}
