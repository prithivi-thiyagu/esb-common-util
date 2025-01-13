package com.bandhanbank.esb.common.util.ExceptionHandler.Exceptions.CustomExceptions;

public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException(String message){
        super(message);
    }

}
