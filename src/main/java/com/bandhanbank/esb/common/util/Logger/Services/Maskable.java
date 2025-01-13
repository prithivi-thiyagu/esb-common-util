package com.bandhanbank.esb.common.util.Logger.Services;

import com.bandhanbank.esb.common.util.Logger.Components.LogDetails;
import com.bandhanbank.esb.common.util.Logger.Components.LogEnvelope;
import com.bandhanbank.esb.common.util.Logger.Components.LogEnvelopeParameters;

public interface Maskable {
    LogDetails mask(LogDetails logdetails);
}
