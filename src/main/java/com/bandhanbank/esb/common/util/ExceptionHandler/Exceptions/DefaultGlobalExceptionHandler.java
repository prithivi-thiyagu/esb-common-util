package com.bandhanbank.esb.common.util.ExceptionHandler.Exceptions;


import com.bandhanbank.esb.common.util.ExceptionHandler.Exceptions.CustomExceptions.*;
import com.bandhanbank.esb.common.util.ExceptionHandler.Models.ErrorResponse;
import com.bandhanbank.esb.common.util.ExceptionHandler.Models.Message;
import com.bandhanbank.esb.common.util.ExceptionHandler.Configs.ExceptionErrorCodeMapping;
import com.bandhanbank.esb.common.util.Logger.Components.LogEnvelopeParameters;
import com.bandhanbank.esb.common.util.Logger.Services.ExceptionLoggingService;
import com.bandhanbank.esb.common.util.Logger.Services.SetLogEnvelopeParameterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@Order(3)
public class DefaultGlobalExceptionHandler {
    @Autowired
    private ExceptionErrorCodeMapping errorCodeMapping;
    @Autowired
    ErrorResponse errorResponse;
    @Autowired
    Message message;
    @Autowired
    private SetLogEnvelopeParameterService setLogEnvelopeParameterService;
    @Autowired
    private ExceptionLoggingService exceptionLoggingService;
    @Autowired
    LogEnvelopeParameters logEnvelopeParameters;

    //handle technical exceptions


    //handle Business exceptions


    @ExceptionHandler({RestAPIException.class, TCPException.class, JavaException.class,
            InvalidRequestException.class, InvalidResponseException.class, ParseException.class,
            RenderException.class, SOAPException.class, MAILException.class})
    public ResponseEntity<ErrorResponse> handleKnownExceptions(RuntimeException ex) {
        log.error("Exception occurred: {}", ex.getMessage(), ex);
        String errorCode = errorCodeMapping.getErrorCode(ex.getClass());

        if (errorCode == null) {
            // Default error code based on error type
            errorCode = determineDefaultErrorCode(determineErrorSource(ex));
        }
        String errorType = categorizeError(errorCode);
        return buildErrorResponse(ex, errorCode, errorType);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        log.error("Unhandled exception occurred: {}", ex.getMessage(), ex);
        return buildErrorResponse(ex, "-1", "Unknown");
    }

    private String determineDefaultErrorCode(String errorSource) {
        if ("Provider".equals(errorSource)) {
            return "-1"; // Default for technical errors
        } else if ("Consumer".equals(errorSource)) {
            return "-2"; // Default for business errors
        }
        return "-1"; // Fallback default
    }

    private String categorizeError(String errorCode) {
        if (errorCode == null || errorCode.length() < 4) {
            log.warn("Invalid or missing error code: Defaulting to Unknown error type");
            return "Unknown";
        }
        int code;
        try {
            code = Integer.parseInt(errorCode.substring(3));
        } catch (NumberFormatException e) {
            log.warn("Error code is not properly formatted: {}. Defaulting to Unknown", errorCode);
            return "Unknown";
        }

        if (code >= 500 && code <= 599) {
            return "Technical";
        } else if (code >= 400 && code <= 499) {
            return "Business";
        }
        log.warn("Unrecognized error code range: {}. Defaulting to Unknown", errorCode);
        return "Unknown";
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(Exception ex, String errorCode, String errorType) {
        ErrorResponse errorResponse = new ErrorResponse();
        int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
        try {
            statusCode = Integer.parseInt(errorCode.substring(3));
        } catch (NumberFormatException e) {
            log.warn("Invalid error code, defaulting to 500");
        }
        errorResponse.setStatusCode(statusCode);

        // Create error message
        Message message = new Message();
        message.setErrorCode(errorCode != null ? errorCode : "-1");
        message.setErrorMessage(ex.getMessage() + " | Cause: " + (ex.getCause() != null ? ex.getCause().getMessage() : "N/A"));

        // Include errorType and errorSource only for non-generic errors
        if (!"-1".equals(errorCode)) {
            message.setErrorType(errorType);
            message.setErrorSource(determineErrorSource(ex));
        }
        errorResponse.setMessage(message);
        HttpStatus status = HttpStatus.valueOf(statusCode);
        return new ResponseEntity<>(errorResponse, status);
    }

    private String determineErrorSource(Exception ex) {

        if (ex instanceof RestAPIException || ex instanceof TCPException || ex instanceof JavaException
                || ex instanceof MAILException || ex instanceof RenderException || ex instanceof SOAPException) {
            return "Provider";
        } else if (ex instanceof InvalidRequestException || ex instanceof InvalidResponseException || ex instanceof ParseException) {
            return "Consumer";
        } else {
            return "Unknown";
        }
    }

}
