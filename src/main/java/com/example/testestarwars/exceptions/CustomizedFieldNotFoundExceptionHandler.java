package com.example.testestarwars.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedFieldNotFoundExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ExceptionResponse> handlerArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
                "O body da requisição que você mandou está faltando campos obrigatórios " +
                        "ou os campos estão enviando valores vazios. Verifique se você está mandando os campos " +
                        "name, terrain e climate, e se você está mandando esses campos com valores válidos.",
                request.getDescription(false), HttpStatus.BAD_REQUEST.getReasonPhrase());

        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
