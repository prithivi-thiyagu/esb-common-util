package com.bandhanbank.esb.common.util.Logger.Components;

import org.springframework.beans.factory.annotation.Autowired;

public class ErrorPayloadDetails extends LogDetails{

    @Autowired
    public ErrorPayloadDetails(LogEnvelopeParameters logEnvelopeParameters){
        super(logEnvelopeParameters);
        this.setErrorCode(logEnvelopeParameters.getErrorCode());
        this.setErrorDescription(logEnvelopeParameters.getErrorDescription());
        this.setErrorSource(logEnvelopeParameters.getErrorSource());
        this.setErrorType(logEnvelopeParameters.getErrorType());
        this.setStackTrace(logEnvelopeParameters.getStackTrace());
    }

    @Override
    public String toString() {
        return "ErrorDetails: { " +
                "ErrorCode: '" + this.getErrorCode() +
                "', ErrorSource: '" + this.getErrorSource() +
                "', ErrorType: '" + this.getErrorType() +
                "', StackTrace: '" + this.getStackTrace() +
                "', ErrorDescription: '" + this.getErrorDescription() +
                "' }";
    }
}