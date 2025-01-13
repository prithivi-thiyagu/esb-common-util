package com.bandhanbank.esb.common.util.Logger.Services;

import com.bandhanbank.esb.common.util.Logger.Adapters.ErrorAdapter;
import com.bandhanbank.esb.common.util.Logger.Adapters.LogEnvelopeAdapter;
import com.bandhanbank.esb.common.util.Logger.Components.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Slf4j
@Service
public class ExceptionLoggingService implements Logable{
    @Autowired
    LogEnvelope logEnvelope;

    private LogEnvelopeParameters logEnvelopeParameters;

    @Autowired
    public ExceptionLoggingService(LogEnvelopeParameters logEnvelopeParameters){
        this.logEnvelopeParameters = logEnvelopeParameters;
    }

    @Override
    public void log(LogEnvelopeParameters logEnvelopeParameters) throws JsonProcessingException {
        LogEnvelopeAdapter logEnvelopeAdapter = new ErrorAdapter();
        LogHeaders logHeaders = logEnvelopeAdapter.getLogHeaders(logEnvelopeParameters);
        LogDetails logDetails = logEnvelopeAdapter.getLogDetails(logEnvelopeParameters);

        logEnvelope.setLogHeaders(logHeaders);
        logEnvelope.setLogDetails(logDetails);

        log.info("{ LogHeaders: { {} }, LogDetails: { {} } }", logHeaders.toString(), logDetails.toString());
    }
}
