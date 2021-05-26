package com.example.testestarwars.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String request;
    private String httpCodeMessage;

    public ExceptionResponse(Date timestamp, String message, String request, String httpCodeMessage) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.request = request;
        this.httpCodeMessage=httpCodeMessage;
    }
}
