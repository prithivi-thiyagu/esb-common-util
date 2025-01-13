package com.bandhanbank.esb.common.util.ExceptionHandler.Exceptions;

import com.bandhanbank.esb.common.util.ExceptionHandler.Exceptions.CustomExceptions.ReplyCodeNotZeroException;
import com.bandhanbank.esb.common.util.ExceptionHandler.Models.ErrorResponse;
import com.bandhanbank.esb.common.util.Logger.Components.LogEnvelopeParameters;
import com.bandhanbank.esb.common.util.Logger.Services.ExceptionLoggingService;
import com.bandhanbank.esb.common.util.Logger.Services.SetLogEnvelopeParameterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
@Order(1)
public class TechnicalGlobalExceptionHandler {

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) throws JsonProcessingException {
//        errorResponse = createErrorResponse.createErrorResponse(ex.getStatusCode().value(),String.valueOf(ex.getStatusCode().value())
//                ,ex.getMessage(),"ESB", ErrorType.Technical.toString());

        List<ObjectError> errorList = ex.getBindingResult().getAllErrors();
        String excMssg = "";

        for(ObjectError i : errorList) {
            excMssg +=  i.getDefaultMessage() + ", ";
        }

        excMssg = excMssg.substring(0,excMssg.length()-2);

        errorResponse = createErrorResponse.createErrorResponse(ex.getStatusCode().value(),String.valueOf(ex.getStatusCode().value())
                ,excMssg,"ESB", ErrorType.Technical.toString());

        logEnvelopeParameters = setLogEnvelopeParameterService.setLogEnveloperParameters(errorResponse,logEnvelopeParameters.getHeaders(),logEnvelopeParameters.getParams(), logEnvelopeParameters.getVersion(),logEnvelopeParameters.getFunction()
                ,logEnvelopeParameters.getDomain(),"ESB ERR","ERROR");

        logEnvelopeParameters = setLogEnvelopeParameterService.setErrorLogParameters("ESB ERR",String.valueOf(ex.getStatusCode().value()),
                "ESB", "ESB ERROR", Arrays.toString(ex.getStackTrace()), excMssg);
        exceptionLoggingService.log(logEnvelopeParameters);

        return new ResponseEntity<>(errorResponse, ex.getStatusCode());
    }
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorResponse> handleMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) throws JsonProcessingException {
        errorResponse = createErrorResponse.createErrorResponse(ex.getStatusCode().value(),String.valueOf(ex.getStatusCode().value())
                ,ex.getMessage(),"ESB", ErrorType.Technical.toString());

        logEnvelopeParameters = setLogEnvelopeParameterService.setLogEnveloperParameters(errorResponse,logEnvelopeParameters.getHeaders(),logEnvelopeParameters.getParams(), logEnvelopeParameters.getVersion(),logEnvelopeParameters.getFunction()
                ,logEnvelopeParameters.getDomain(),"ESB ERR","ERROR");

        logEnvelopeParameters = setLogEnvelopeParameterService.setErrorLogParameters("ESB ERR",String.valueOf(ex.getStatusCode().value()),
                "ESB", "ESB ERROR", Arrays.toString(ex.getStackTrace()), ex.getMessage());
        exceptionLoggingService.log(logEnvelopeParameters);

        return new ResponseEntity<>(errorResponse, ex.getStatusCode());
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) throws JsonProcessingException {
        errorResponse = createErrorResponse.createErrorResponse(400,"400"
                ,ex.getMessage(),"ESB",ErrorType.Technical.toString());

        logEnvelopeParameters = setLogEnvelopeParameterService.setLogEnveloperParameters(errorResponse,logEnvelopeParameters.getHeaders(),logEnvelopeParameters.getParams(), logEnvelopeParameters.getVersion(),logEnvelopeParameters.getFunction()
                ,logEnvelopeParameters.getDomain(),"ESB ERR","ERROR");

        logEnvelopeParameters = setLogEnvelopeParameterService.setErrorLogParameters("ESB ERR","400",
                "ESB", "ESB ERROR", Arrays.toString(ex.getStackTrace()), ex.getMessage());
        exceptionLoggingService.log(logEnvelopeParameters);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({JpaSystemException.class})
    public ResponseEntity<ErrorResponse> handleJpaSystemException(JpaSystemException ex) throws JsonProcessingException {
        errorResponse = createErrorResponse.createErrorResponse(400,"400"
                ,"CustomerNumber cannot be null: " + ex.getMessage(),"ESB",ErrorType.Technical.toString());

        logEnvelopeParameters = setLogEnvelopeParameterService.setLogEnveloperParameters(errorResponse,logEnvelopeParameters.getHeaders(),logEnvelopeParameters.getParams(), logEnvelopeParameters.getVersion(),logEnvelopeParameters.getFunction()
                ,logEnvelopeParameters.getDomain(),"ESB ERR","ERROR");

        logEnvelopeParameters = setLogEnvelopeParameterService.setErrorLogParameters("ESB ERR","400",
                "ESB", "ESB ERROR", Arrays.toString(ex.getStackTrace()), ex.getMessage());
        exceptionLoggingService.log(logEnvelopeParameters);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ReplyCodeNotZeroException.class})
    public ResponseEntity<ErrorResponse> handleReplyCodeNotZeroException(RuntimeException ex) throws JsonProcessingException {
        errorResponse = createErrorResponse.createErrorResponse(400,"400"
                ,ex.getMessage(),"Provider",ErrorType.Business.toString());

        logEnvelopeParameters = setLogEnvelopeParameterService.setLogEnveloperParameters(errorResponse,logEnvelopeParameters.getHeaders(),logEnvelopeParameters.getParams(), logEnvelopeParameters.getVersion(),logEnvelopeParameters.getFunction()
                ,logEnvelopeParameters.getDomain(),"ESB ERR","ERROR");

        logEnvelopeParameters = setLogEnvelopeParameterService.setErrorLogParameters("ESB ERR","400",
                "Provider", "ESB ERROR",Arrays.toString(ex.getStackTrace()), ex.getMessage());
        exceptionLoggingService.log(logEnvelopeParameters);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoResourceFoundException(NoResourceFoundException ex) throws JsonProcessingException {
        errorResponse = createErrorResponse.createErrorResponse(ex.getStatusCode().value(),String.valueOf(ex.getStatusCode().value())
                ,ex.getMessage(),"ESB",ErrorType.Technical.toString());

        logEnvelopeParameters = setLogEnvelopeParameterService.setLogEnveloperParameters(errorResponse,logEnvelopeParameters.getHeaders(),logEnvelopeParameters.getParams(), logEnvelopeParameters.getVersion(),logEnvelopeParameters.getFunction()
                ,logEnvelopeParameters.getDomain(),"ESB ERR","ERROR");

        logEnvelopeParameters = setLogEnvelopeParameterService.setErrorLogParameters("ESB ERR",String.valueOf(ex.getStatusCode().value()),
                "ESB", "ESB ERROR",Arrays.toString(ex.getStackTrace()), ex.getMessage());
        exceptionLoggingService.log(logEnvelopeParameters);

        return new ResponseEntity<>(errorResponse, ex.getStatusCode());
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ErrorResponse> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex) throws JsonProcessingException {
        errorResponse = createErrorResponse.createErrorResponse(ex.getStatusCode().value(),String.valueOf(ex.getStatusCode().value())
                ,ex.getMessage(),"ESB",ErrorType.Technical.toString());

        logEnvelopeParameters = setLogEnvelopeParameterService.setLogEnveloperParameters(errorResponse,logEnvelopeParameters.getHeaders(),logEnvelopeParameters.getParams(), logEnvelopeParameters.getVersion(),logEnvelopeParameters.getFunction()
                ,logEnvelopeParameters.getDomain(),"ESB ERR","ERROR");

        logEnvelopeParameters = setLogEnvelopeParameterService.setErrorLogParameters("ESB ERR",String.valueOf(ex.getStatusCode().value()),
                "ESB", "ESB ERROR", Arrays.toString(ex.getStackTrace()), ex.getMessage());
        exceptionLoggingService.log(logEnvelopeParameters);

        return new ResponseEntity<>(errorResponse, ex.getStatusCode());
    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException ex) throws JsonProcessingException {
        errorResponse = createErrorResponse.createErrorResponse(500,"500"
                ,ex.getMessage(),"ESB",ErrorType.Technical.toString());

        logEnvelopeParameters = setLogEnvelopeParameterService.setLogEnveloperParameters(errorResponse,logEnvelopeParameters.getHeaders(),logEnvelopeParameters.getParams(), logEnvelopeParameters.getVersion(),logEnvelopeParameters.getFunction()
                ,logEnvelopeParameters.getDomain(),"ESB ERR","ERROR");

        logEnvelopeParameters = setLogEnvelopeParameterService.setErrorLogParameters("ESB ERR","500",
                "ESB", "ESB ERROR", Arrays.toString(ex.getStackTrace()), ex.getMessage());
        exceptionLoggingService.log(logEnvelopeParameters);

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
