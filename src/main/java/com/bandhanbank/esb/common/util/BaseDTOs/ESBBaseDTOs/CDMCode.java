package com.bandhanbank.esb.common.util.BaseDTOs.ESBBaseDTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CDMCode {
    @JsonProperty("mutable")
    protected Boolean mutable;
    @JsonProperty("enumValue")
    protected String enumValue;
    @JsonProperty("value")
    protected String value;
}
