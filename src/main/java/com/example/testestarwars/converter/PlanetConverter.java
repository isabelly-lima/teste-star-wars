package com.example.testestarwars.converter;

import com.example.testestarwars.dto.PlanetDto;
import com.example.testestarwars.model.Planet;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Mapper(componentModel = "spring",
        disableSubMappingMethodsGeneration = true)
public interface PlanetConverter {

    @Named("toPlanetDto")
    PlanetDto toPlanetDto(Planet planet);

    @IterableMapping(qualifiedByName = "toPlanetDto")
    List<PlanetDto> toPlanetDto(List<Planet> planets);
}
