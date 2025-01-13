package com.bandhanbank.esb.common.util.Logger.Components;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class ErrorDetails extends LogDetails{

    @Autowired
    public ErrorDetails(LogEnvelopeParameters logEnvelopeParameters){
        super(logEnvelopeParameters);
        this.setErrorCode(logEnvelopeParameters.getErrorCode());
        this.setErrorDescription(logEnvelopeParameters.getErrorDescription());
        this.setErrorSource(logEnvelopeParameters.getErrorSource());
        this.setErrorType(logEnvelopeParameters.getErrorType());
        this.setStackTrace(logEnvelopeParameters.getStackTrace());
    }

    @Override
    public String toString() {
        return "Error Details: { " +
                "Error Code: '" + this.getErrorCode() +
                "', Error Source: '" + this.getErrorSource() +
                "', Error Type: '" + this.getErrorType() +
                "', Error Trace: '" + this.getStackTrace() +
                "', Error Description: '" + this.getErrorDescription() +
                "' }";
    }
}