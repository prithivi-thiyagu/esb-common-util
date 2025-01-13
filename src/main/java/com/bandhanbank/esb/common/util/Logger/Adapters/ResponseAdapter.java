package com.bandhanbank.esb.common.util.Logger.Adapters;

import com.bandhanbank.esb.common.util.Logger.Components.LogDetails;
import com.bandhanbank.esb.common.util.Logger.Components.LogEnvelopeParameters;
import com.bandhanbank.esb.common.util.Logger.Components.LogHeaders;
import com.bandhanbank.esb.common.util.Logger.Components.ResponsePayloadDetails;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ResponseAdapter implements LogEnvelopeAdapter{

    @Override
    public LogHeaders getLogHeaders(LogEnvelopeParameters logEnvelopeParameters) {
        return new LogHeaders(logEnvelopeParameters);
    }

    @Override
    public LogDetails getLogDetails(LogEnvelopeParameters logEnvelopeParameters) throws JsonProcessingException {
        return new ResponsePayloadDetails(logEnvelopeParameters);
    }
}
