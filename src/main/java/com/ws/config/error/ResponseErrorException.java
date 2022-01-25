package com.ws.config.error;

import lombok.Getter;

@Getter
public class ResponseErrorException {

    private String exception;
    private String message;

    public ResponseErrorException(String exception,String message) {
        this.exception = exception;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseException{" +
                "exception='" + exception + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}