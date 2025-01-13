package com.bandhanbank.esb.common.util.Logger.Components;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class RequestPayloadDetails extends ResponsePayloadDetails {
    private List<String> paramsList;

    @Autowired
    public RequestPayloadDetails(LogEnvelopeParameters logEnvelopeParameters) throws JsonProcessingException {
        super(logEnvelopeParameters);
        Map<String,String> params = logEnvelopeParameters.getParams();
        if(!params.isEmpty()){
            paramsList = new ArrayList<>();
            for(Map.Entry<String,String> it : params.entrySet())
                paramsList.add(it.getValue());
        }
        this.setParameters(paramsList);
    }

    @Override
    public String toString() {
        return "RequestPayload: { " +
                "Body: '" + this.getBody() +
                "', DynamicParameters: '" + this.getDynamicParameters() +
                "', Parameters: '" + this.getParameters() +
                "', Headers: '" + this.getHeaders() +
                "' }";
    }
}
