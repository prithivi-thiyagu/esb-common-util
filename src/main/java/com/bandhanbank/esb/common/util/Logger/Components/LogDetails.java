package com.bandhanbank.esb.common.util.Logger.Components;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
public class LogDetails {
    private String body;
    private List<DynamicParamsPair> dynamicParameters;
    private List<String> headers;
    private List<String> parameters;
    private String errorCode;
    private String errorDescription;
    private String errorSource;
    private String errorType;
    private String stackTrace;

    private LogEnvelopeParameters logEnvelopeParameters;

    @Autowired
    public LogDetails(LogEnvelopeParameters logEnvelopeParameters){
        this.logEnvelopeParameters = logEnvelopeParameters;
    }
}
