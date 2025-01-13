package com.bandhanbank.esb.common.util.BaseDTOs.ESBBaseDTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CDMMessage {
    @JsonProperty("Code")
    protected CDMCode code;
    @JsonProperty("Message")
    protected String message;
    @JsonProperty("Item")
    protected List<CDMItemExtndReply> item;
}
