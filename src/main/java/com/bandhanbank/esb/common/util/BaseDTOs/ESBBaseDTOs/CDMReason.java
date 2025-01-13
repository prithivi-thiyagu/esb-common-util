package com.bandhanbank.esb.common.util.BaseDTOs.ESBBaseDTOs;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CDMReason {
   
   @JsonProperty("ReasonCode")
   protected Integer reasonCode;
   @JsonProperty("Comment")
   protected String comment;

}