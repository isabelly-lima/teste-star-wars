package com.example.testestarwars.exceptions;

import java.util.Date;

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

    public String getHttpCodeMessage() {
        return httpCodeMessage;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return this.message;
    }

    public String getRequest() {
        return this.request;
    }
}
