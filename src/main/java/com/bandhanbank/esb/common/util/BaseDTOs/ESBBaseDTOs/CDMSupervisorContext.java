package com.bandhanbank.esb.common.util.BaseDTOs.ESBBaseDTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CDMSupervisorContext {
 
	@JsonProperty("UserId")
	protected String userId;
	@JsonProperty("PrimaryPassword")
	protected String primaryPassword;
}