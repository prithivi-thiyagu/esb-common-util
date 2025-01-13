package com.bandhanbank.esb.common.util.Logger.Adapters;

import com.bandhanbank.esb.common.util.Logger.Components.LogDetails;
import com.bandhanbank.esb.common.util.Logger.Components.LogEnvelopeParameters;
import com.bandhanbank.esb.common.util.Logger.Components.LogHeaders;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface LogEnvelopeAdapter {
    LogHeaders getLogHeaders(LogEnvelopeParameters logEnvelopeParameters);
    LogDetails getLogDetails(LogEnvelopeParameters logEnvelopeParameters) throws JsonProcessingException;
}
