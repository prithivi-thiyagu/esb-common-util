package com.bandhanbank.esb.common.util.Logger.Services;

import com.bandhanbank.esb.common.util.Logger.Components.LogEnvelope;
import com.bandhanbank.esb.common.util.Logger.Components.LogEnvelopeParameters;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface Logable {
    void log(LogEnvelopeParameters logEnvelopeParameters) throws JsonProcessingException;
}
