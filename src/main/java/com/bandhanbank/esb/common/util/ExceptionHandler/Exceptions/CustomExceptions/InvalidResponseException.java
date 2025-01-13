package com.bandhanbank.esb.common.util.ExceptionHandler.Exceptions.CustomExceptions;

public class InvalidResponseException extends RuntimeException {
    public InvalidResponseException(String message){
        super(message);
    }
}
