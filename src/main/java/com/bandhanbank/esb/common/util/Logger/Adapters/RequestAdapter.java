package com.bandhanbank.esb.common.util.Logger.Adapters;

import com.bandhanbank.esb.common.util.Logger.Components.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class RequestAdapter implements LogEnvelopeAdapter{

    @Autowired
    LogDetails logDetails;

    @Override
    public LogHeaders getLogHeaders(LogEnvelopeParameters logEnvelopeParameters) {
        return new LogHeaders(logEnvelopeParameters);
    }

    @Override
    public LogDetails getLogDetails(LogEnvelopeParameters logEnvelopeParameters) throws JsonProcessingException {
        return new RequestPayloadDetails(logEnvelopeParameters);
    }
}
