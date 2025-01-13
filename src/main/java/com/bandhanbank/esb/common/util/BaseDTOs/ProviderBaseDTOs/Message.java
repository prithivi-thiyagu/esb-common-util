package com.bandhanbank.esb.common.util.BaseDTOs.ProviderBaseDTOs;

import com.bandhanbank.esb.common.util.BaseDTOs.ESBBaseDTOs.CDMCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message {
    @JsonProperty("Code")
    protected CDMCode code;
    @JsonProperty("message")
    protected String message;
    @JsonProperty("item")
    protected List<ItemExtndReply> item;
}
