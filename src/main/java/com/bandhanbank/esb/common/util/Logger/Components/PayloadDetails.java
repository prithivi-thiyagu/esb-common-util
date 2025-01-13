package com.bandhanbank.esb.common.util.Logger.Components;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public class PayloadDetails extends LogDetails{

    @Autowired
    public PayloadDetails(LogEnvelopeParameters logEnvelopeParameters) throws JsonProcessingException {
        super(logEnvelopeParameters);
        ObjectMapper objectMapper = new ObjectMapper();
        this.setBody(objectMapper.writeValueAsString(logEnvelopeParameters.getBody()));
    }

    @Override
    public String toString() {
        return "Response Payload: { " +
                "Body: '" + this.getBody() +
                "', Dynamic Parameters: '" + this.getDynamicParameters() +
                "', Parameters: '" + this.getParameters() +
                "', Headers: '" + this.getHeaders() +
                "' }";
    }
}