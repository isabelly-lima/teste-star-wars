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

    @NotBlank
    @Size(max = 200)
    private String name;

    @NotBlank
    @Size(max = 200)
    private String climate;

    @NotNull
    @Size(max = 200)
    private String terrain;

    @NotNull
    private Integer numberOfMovieAppearances;
}
