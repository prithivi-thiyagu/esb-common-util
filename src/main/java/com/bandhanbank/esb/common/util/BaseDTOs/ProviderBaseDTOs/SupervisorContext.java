package com.bandhanbank.esb.common.util.BaseDTOs.ProviderBaseDTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupervisorContext {
 
	@JsonProperty("userId")
	protected String userId;
	@JsonProperty("primaryPassword")
	protected String primaryPassword;
}