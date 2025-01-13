package com.bandhanbank.esb.common.util.ExceptionHandler.Exceptions;

import com.bandhanbank.esb.common.util.ExceptionHandler.Exceptions.CustomExceptions.Business4xxCustomException;
import com.bandhanbank.esb.common.util.ExceptionHandler.Exceptions.CustomExceptions.Business5xxCustomException;
import com.bandhanbank.esb.common.util.ExceptionHandler.Models.ErrorResponse;
import com.bandhanbank.esb.common.util.Logger.Components.LogEnvelopeParameters;
import com.bandhanbank.esb.common.util.Logger.Services.ExceptionLoggingService;
import com.bandhanbank.esb.common.util.Logger.Services.SetLogEnvelopeParameterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import java.util.Arrays;

@RestControllerAdvice
@Order(2)
public class BusinessGlobalExceptionHandler {

    @Autowired
    LogEnvelopeParameters logEnvelopeParameters;
    @Autowired
    SetLogEnvelopeParameterService setLogEnvelopeParameterService;
    @Autowired
    ExceptionLoggingService exceptionLoggingService;
    @Autowired
    ErrorResponse errorResponse;
    @Autowired
    CreateErrorResponse createErrorResponse;

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ErrorResponse> handleHttpClientErrorException(HttpClientErrorException ex) throws JsonProcessingException {
        errorResponse = createErrorResponse.createErrorResponse(ex.getStatusCode().value(),String.valueOf(ex.getStatusCode().value())
                ,ex.getMessage(),"Provider",ErrorType.Business.toString());

        logEnvelopeParameters = setLogEnvelopeParameterService.setLogEnveloperParameters(errorResponse,logEnvelopeParameters.getHeaders(),logEnvelopeParameters.getParams(), logEnvelopeParameters.getVersion(),logEnvelopeParameters.getFunction()
        ,logEnvelopeParameters.getDomain(),"PROV ERR","ERROR");

        logEnvelopeParameters = setLogEnvelopeParameterService.setErrorLogParameters("PROV ERR",String.valueOf(ex.getStatusCode().value()),
                "Provider", "PROV ERROR", Arrays.toString(ex.getStackTrace()), ex.getMessage());
        exceptionLoggingService.log(logEnvelopeParameters);

        return new ResponseEntity<>(errorResponse, ex.getStatusCode());
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<ErrorResponse> handleHttpServerErrorException(HttpServerErrorException ex) throws JsonProcessingException {
        errorResponse = createErrorResponse.createErrorResponse(ex.getStatusCode().value(),String.valueOf(ex.getStatusCode().value())
                ,ex.getMessage(),"Provider",ErrorType.Business.toString());

        logEnvelopeParameters = setLogEnvelopeParameterService.setLogEnveloperParameters(errorResponse,logEnvelopeParameters.getHeaders(),logEnvelopeParameters.getParams(), logEnvelopeParameters.getVersion(),logEnvelopeParameters.getFunction()
                ,logEnvelopeParameters.getDomain(),"PROV ERR","ERROR");

        logEnvelopeParameters = setLogEnvelopeParameterService.setErrorLogParameters("PROV ERR",String.valueOf(ex.getStatusCode().value()),
                "Provider", "PROV ERROR", Arrays.toString(ex.getStackTrace()), ex.getMessage());
        exceptionLoggingService.log(logEnvelopeParameters);

        return new ResponseEntity<>(errorResponse, ex.getStatusCode());
    }

    @ExceptionHandler(UnknownHttpStatusCodeException.class)
    public ResponseEntity<ErrorResponse> handleUnknownHttpStatusCodeException(UnknownHttpStatusCodeException ex) throws JsonProcessingException {
        errorResponse = createErrorResponse.createErrorResponse(ex.getStatusCode().value(),String.valueOf(ex.getStatusCode().value())
                ,ex.getMessage(),"Provider",ErrorType.Business.toString());

        logEnvelopeParameters = setLogEnvelopeParameterService.setLogEnveloperParameters(errorResponse,logEnvelopeParameters.getHeaders(),logEnvelopeParameters.getParams(), logEnvelopeParameters.getVersion(),logEnvelopeParameters.getFunction()
                ,logEnvelopeParameters.getDomain(),"PROV ERR","ERROR");

        logEnvelopeParameters = setLogEnvelopeParameterService.setErrorLogParameters("PROV ERR",String.valueOf(ex.getStatusCode().value()),
                "Provider", "PROV ERROR",Arrays.toString(ex.getStackTrace()), ex.getMessage());
        exceptionLoggingService.log(logEnvelopeParameters);

        return new ResponseEntity<>(errorResponse, ex.getStatusCode());
    }

    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<ErrorResponse> handleResourceAccessException(ResourceAccessException ex) throws JsonProcessingException {
        errorResponse = createErrorResponse.createErrorResponse(502,"502"
                ,ex.getMessage(),"Provider",ErrorType.Business.toString());

        logEnvelopeParameters = setLogEnvelopeParameterService.setLogEnveloperParameters(errorResponse,logEnvelopeParameters.getHeaders(),logEnvelopeParameters.getParams(), logEnvelopeParameters.getVersion(),logEnvelopeParameters.getFunction()
                ,logEnvelopeParameters.getDomain(),"PROV ERR","ERROR");

        logEnvelopeParameters = setLogEnvelopeParameterService.setErrorLogParameters("PROV ERR","502",
                "Provider", "PROV ERROR",Arrays.toString(ex.getStackTrace()), ex.getMessage());

        exceptionLoggingService.log(logEnvelopeParameters);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(Business4xxCustomException.class)
    public ResponseEntity<ErrorResponse> handleDefault4xxBusinessException(Business4xxCustomException ex) throws JsonProcessingException {
        errorResponse = createErrorResponse.createErrorResponse(400,"400"
                ,ex.getMessage(),"Provider",ErrorType.Business.toString());

        logEnvelopeParameters = setLogEnvelopeParameterService.setLogEnveloperParameters(errorResponse,logEnvelopeParameters.getHeaders(),logEnvelopeParameters.getParams(), logEnvelopeParameters.getVersion(),logEnvelopeParameters.getFunction()
                ,logEnvelopeParameters.getDomain(),"PROV ERR","ERROR");

        logEnvelopeParameters = setLogEnvelopeParameterService.setErrorLogParameters("PROV ERR","400",
                "Provider", "PROV ERROR",Arrays.toString(ex.getStackTrace()), ex.getMessage());

        exceptionLoggingService.log(logEnvelopeParameters);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(Business5xxCustomException.class)
    public ResponseEntity<ErrorResponse> handleDefault5xxBusinessException(Business5xxCustomException ex) throws JsonProcessingException {
        errorResponse = createErrorResponse.createErrorResponse(500,"500"
                ,ex.getMessage(),"Provider",ErrorType.Business.toString());

        logEnvelopeParameters = setLogEnvelopeParameterService.setLogEnveloperParameters(errorResponse,logEnvelopeParameters.getHeaders(),logEnvelopeParameters.getParams(), logEnvelopeParameters.getVersion(),logEnvelopeParameters.getFunction()
                ,logEnvelopeParameters.getDomain(),"PROV ERR","ERROR");

        logEnvelopeParameters = setLogEnvelopeParameterService.setErrorLogParameters("PROV ERR","500",
                "Provider", "PROV ERROR",Arrays.toString(ex.getStackTrace()), ex.getMessage());

        exceptionLoggingService.log(logEnvelopeParameters);

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
