package com.example.testestarwars.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Document(collection = "planet")
@ToString(of = {"id"})
@Setter
@Getter
@EqualsAndHashCode(of = "_id")
@AllArgsConstructor
@NoArgsConstructor
public class Planet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotBlank(message = "{field.required}")
    @Size(max = 200, message = "{wrong.size}")
    private String name;

    @NotBlank(message = "{field.required}")
    @Size(max = 200, message = "{wrong.size}")
    private String climate;

    @NotNull(message = "Campo obrigatório. Por favor, insira o terreno do planeta.")
    @Size(max = 200, message = "{wrong.size}")
    private String terrain;

    @NotNull(message = "{field.required}")
    private Integer numberOfMovieAppearances;
}
