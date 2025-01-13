package com.bandhanbank.esb.common.util.ExceptionHandler.Exceptions;

import com.bandhanbank.esb.common.util.ExceptionHandler.Models.ErrorResponse;
import com.bandhanbank.esb.common.util.ExceptionHandler.Models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateErrorResponse {

    @Autowired
    ErrorResponse errorResponse;
    @Autowired
    Message message;

    public ErrorResponse createErrorResponse(int statusCode, String errorCode, String errorMessage, String errorSource, String errorType) {
        errorResponse.setStatusCode(statusCode);

        message.setErrorCode(errorCode);
        message.setErrorMessage(errorMessage);
        message.setErrorSource(errorSource);
        message.setErrorType(errorType);

        errorResponse.setMessage(message);

        return errorResponse;
    }
}
