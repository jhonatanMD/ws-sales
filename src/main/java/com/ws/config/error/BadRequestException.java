package com.ws.config.error;

public class BadRequestException extends RuntimeException{

    private static final String DESCRIPTION = "BAD REQUEST (400)";

    public BadRequestException(String detail){
        super(DESCRIPTION + " . "+detail);
    }
}