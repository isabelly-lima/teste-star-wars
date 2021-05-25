package com.example.testestarwars.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "planet")
@ToString(of = {"planetId"})
@Setter
@Getter
@EqualsAndHashCode(of = "planetId")
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String planetId;

    @NotBlank(message = "{field.required}")
    @Size(max = 200, message = "{wrong.size}")
    private String name;

    @NotBlank(message = "{field.required}")
    @Size(max = 200, message = "{wrong.size}")
    private String climate;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "{field.required}")
    private PlanetTerrainEnum planetTerrainEnum;

    @NotNull(message = "{field.required}")
    private Integer numberOfMovieAppearances;
}
