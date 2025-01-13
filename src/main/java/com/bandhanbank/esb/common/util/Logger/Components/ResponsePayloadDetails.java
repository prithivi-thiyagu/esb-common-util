package com.bandhanbank.esb.common.util.Logger.Components;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;

public class ResponsePayloadDetails extends LogDetails{

    @Autowired
    public ResponsePayloadDetails(LogEnvelopeParameters logEnvelopeParameters) throws JsonProcessingException {
        super(logEnvelopeParameters);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        this.setBody(objectMapper.writeValueAsString(logEnvelopeParameters.getBody()));
    }

    @Override
    public String toString() {
        return "ResponsePayload: { " +
                "Body: '" + this.getBody() +
                "', DynamicParameters: '" + this.getDynamicParameters() +
                "', Parameters: '" + this.getParameters() +
                "', Headers: '" + this.getHeaders() +
                "' }";
    }
}