package com.bandhanbank.esb.common.util.BaseDTOs.ProviderBaseDTOs;

import com.bandhanbank.esb.common.util.BaseDTOs.ESBBaseDTOs.CDMCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemExtndReply {
    @JsonProperty("code")
    protected CDMCode code;
    @JsonProperty("Message")
    protected String message;
}
