package com.bandhanbank.esb.common.util.Logger.Services;

import com.bandhanbank.esb.common.util.Logger.Adapters.LogEnvelopeAdapter;
import com.bandhanbank.esb.common.util.Logger.Adapters.RequestAdapter;
import com.bandhanbank.esb.common.util.Logger.Adapters.ResponseAdapter;
import com.bandhanbank.esb.common.util.Logger.Components.LogDetails;
import com.bandhanbank.esb.common.util.Logger.Components.LogEnvelope;
import com.bandhanbank.esb.common.util.Logger.Components.LogEnvelopeParameters;
import com.bandhanbank.esb.common.util.Logger.Components.LogHeaders;
import com.bandhanbank.esb.common.util.Logger.Masking.ValueMasker;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Slf4j
@Service
public class ResponseLoggingService  implements Logable,Maskable{

    @Autowired
    LogEnvelope logEnvelope;

    @Autowired
    private ValueMasker valueMaskerService;

    private LogEnvelopeParameters logEnvelopeParameters;

    @Autowired
    public ResponseLoggingService (LogEnvelopeParameters logEnvelopeParameters){
        this.logEnvelopeParameters = logEnvelopeParameters;
    }

    @Override
    public void log(LogEnvelopeParameters logEnvelopeParameters) throws JsonProcessingException {
        // create the request type LogEnvelope
        LogEnvelopeAdapter logEnvelopeAdapter = new ResponseAdapter();
        // get consumer/provider request header
        LogHeaders logHeaders = logEnvelopeAdapter.getLogHeaders(logEnvelopeParameters);
        // get consumer/provider log detail
        LogDetails logDetails = logEnvelopeAdapter.getLogDetails(logEnvelopeParameters);
        logDetails = mask(logDetails);

        logEnvelope.setLogHeaders(logHeaders);
        logEnvelope.setLogDetails(logDetails);

        log.info("{ LogHeaders: { {} }, LogDetails: { {} } }", logHeaders.toString(), logDetails.toString());
    }

    @Override
    public LogDetails mask(LogDetails logdetails) {
        String maskBody = valueMaskerService.maskRequestResponse(logdetails.getBody());
        logdetails.setBody(maskBody);
        return logdetails;
    }
}
