package com.bandhanbank.esb.common.util.BaseDTOs.ProviderBaseDTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Reason {
 
	@JsonProperty("reasonCode")
	protected Integer reasonCode;
	@JsonProperty("comment")
	protected String comment;

}
