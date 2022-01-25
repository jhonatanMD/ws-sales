package com.ws.config;

import com.ws.config.error.BadRequestException;
import com.ws.config.error.NotFoundException;
import com.ws.config.error.ResponseErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ControllerError {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({
            NoSuchElementException.class,
            NullPointerException.class,
            NotFoundException.class
    })
    @ResponseBody
    public ResponseErrorException exception(  Exception exception){
        return new ResponseErrorException("NOT FOUND","NO SE ENCONTRO ENTIDAD");
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            BadRequestException.class
    })
    @ResponseBody
    public ResponseErrorException exceptionBadRequest(  Exception exception){
        return new ResponseErrorException("BAD REQUEST",exception.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({
            ArithmeticException.class,
            Throwable.class
    })
    @ResponseBody
    public ResponseErrorException server_error( Exception exception){
        if(exception instanceof ArithmeticException)
            return new ResponseErrorException("Server Error","Data Error");

        log.error(exception.getMessage());

        return new ResponseErrorException("Server Error", "OCURRIO UN ERROR INTERNO REVISA EL LOG");
    }

}
