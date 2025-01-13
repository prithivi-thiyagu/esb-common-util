package com.bandhanbank.esb.common.util.Logger.Components;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@Component
public class LogEnvelopeParameters {
    private Object body;
    private Map<String,String> headers;
    private Map<String,String> params;
    private String version;
    private String function;
    private String domain;
    private String logType;
    private String logLevel;
    private String errorCode;
    private String errorDescription;
    private String errorSource;
    private String errorType;
    private String stackTrace;
}