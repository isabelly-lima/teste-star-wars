package com.example.testestarwars.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PlanetAlreadyOnDatabaseException extends RuntimeException {
    public PlanetAlreadyOnDatabaseException(String message) {
        super(message);
    }
}
