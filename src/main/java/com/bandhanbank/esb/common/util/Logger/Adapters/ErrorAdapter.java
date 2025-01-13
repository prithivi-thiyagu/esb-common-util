package com.bandhanbank.esb.common.util.Logger.Adapters;

import com.bandhanbank.esb.common.util.Logger.Components.*;

public class ErrorAdapter implements LogEnvelopeAdapter{

    @Override
    public LogHeaders getLogHeaders(LogEnvelopeParameters logEnvelopeParameters) {
        return new LogHeaders(logEnvelopeParameters);
    }

    @Override
    public LogDetails getLogDetails(LogEnvelopeParameters logEnvelopeParameters){
        return new ErrorPayloadDetails(logEnvelopeParameters);
    }
}
