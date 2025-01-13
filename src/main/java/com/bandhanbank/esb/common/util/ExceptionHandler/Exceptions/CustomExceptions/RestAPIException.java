package com.bandhanbank.esb.common.util.ExceptionHandler.Exceptions.CustomExceptions;

public class RestAPIException extends RuntimeException {
    public RestAPIException(String message){
        super(message);
    }
}
