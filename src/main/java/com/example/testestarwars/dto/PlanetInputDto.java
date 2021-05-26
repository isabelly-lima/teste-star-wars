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
    @NotEmpty(message = "O campo name não pode ser enviado vazio!")
    @NotNull(message = "O campo name não pode ser enviado nulo!")
    @NotBlank (message = "O campo name não pode ser enviado vazio!")
    private String name;

    @NotEmpty(message = "O campo climate não pode ser enviado vazio!")
    @NotNull(message = "O campo climate não pode ser enviado nulo!")
    @NotBlank (message = "O campo climate não pode ser enviado vazio!")
    private String climate;

    @NotEmpty(message = "O campo terrain não pode ser enviado vazio!")
    @NotNull(message = "O campo terrain não pode ser enviado nulo!")
    @NotBlank (message = "O campo terrain não pode ser enviado vazio!")
    private String terrain;
}
