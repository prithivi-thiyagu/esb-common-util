package com.bandhanbank.esb.common.util.Logger.Components;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class LogEnvelope {
    private LogHeaders logHeaders;
    private LogDetails logDetails;
}