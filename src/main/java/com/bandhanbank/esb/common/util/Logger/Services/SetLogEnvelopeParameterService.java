package com.bandhanbank.esb.common.util.Logger.Services;

import com.bandhanbank.esb.common.util.Logger.Components.LogEnvelopeParameters;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SetLogEnvelopeParameterService {

    @Autowired
    LogEnvelopeParameters logEnvelopeParameters;

    public LogEnvelopeParameters setLogEnveloperParameters(Object object, Map<String,String> headers,
                                                    Map<String,String> params, String version,
                                                    String function, String domain, String logType,
                                                    String logLevel){

        logEnvelopeParameters.setBody(object);
        logEnvelopeParameters.setHeaders(headers);
        logEnvelopeParameters.setParams(params);
        logEnvelopeParameters.setVersion(version);
        logEnvelopeParameters.setFunction(function);
        logEnvelopeParameters.setDomain(domain);
        logEnvelopeParameters.setLogType(logType);
        logEnvelopeParameters.setLogLevel(logLevel);
        return logEnvelopeParameters;
    }

    public LogEnvelopeParameters setErrorLogParameters(String logType, String errorCode,
                                                       String errorSource, String errorType,
                                                       String stackTrace, String errorDescription){

        logEnvelopeParameters.setLogType(logType);
        logEnvelopeParameters.setErrorCode(errorCode);
        logEnvelopeParameters.setErrorSource(errorSource);
        logEnvelopeParameters.setErrorType(errorType);
        logEnvelopeParameters.setStackTrace(stackTrace);
        logEnvelopeParameters.setErrorDescription(errorDescription);

        return logEnvelopeParameters;
    }
}
