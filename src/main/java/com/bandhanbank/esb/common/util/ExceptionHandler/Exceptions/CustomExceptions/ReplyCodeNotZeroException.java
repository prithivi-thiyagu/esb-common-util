package com.bandhanbank.esb.common.util.ExceptionHandler.Exceptions.CustomExceptions;

public class ReplyCodeNotZeroException extends RuntimeException{

    public ReplyCodeNotZeroException(String message){
        super(message);
    }

}
