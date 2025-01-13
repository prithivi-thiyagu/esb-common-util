package com.bandhanbank.esb.common.util.BaseDTOs.ProviderBaseDTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonRootName("args0Type")
public class FCCArgsZeroBaseDTO {
 
	@JsonProperty("sessionTicket")
	protected String sessionTicket;
	@JsonProperty("bankCode")
	protected Integer bankCode;
	@JsonProperty("transactionBranch")
	protected Integer transactionBranch;
	@JsonProperty("overridenWarnings")
	protected String overridenWarnings;
	@JsonProperty("localDateTimeText")
	protected String localDateTimeText;
	@JsonProperty("externalReferenceNo")
	protected String externalReferenceNo;
	@JsonProperty("userReferenceNumber")
	protected String userReferenceNumber;
	@JsonProperty("originalReferenceNo")
	protected String originalReferenceNo;
	@JsonProperty("postingDateText")
	protected String postingDateText;
	@JsonProperty("valueDateText")
	protected String valueDateText;
	@JsonProperty("externalBatchNumber")
	protected Long externalBatchNumber;
	@JsonProperty("externalSystemAuditTrailNumber")
	protected Long externalSystemAuditTrailNumber;
	@JsonProperty("channel")
	protected String channel;
	@JsonProperty("userId")
	protected String userId;
	@JsonProperty("supervisorContext")
	protected SupervisorContext supervisorContext;
	@JsonProperty("tellerContext")
	protected TellerContext tellerContext;
	@JsonProperty("serviceCode")
	protected String serviceCode;
	@JsonProperty("electronicJournalOperationType")
	protected String electronicJournalOperationType;
	@JsonProperty("brnPostingDateText")
	protected String brnPostingDateText;
	@JsonProperty("auditComments")
	protected String auditComments;
	@JsonProperty("externalUserId")
	protected String externalUserId;
	@JsonProperty("externalBranchCode")
	protected String externalBranchCode;
	@JsonProperty("sessionContextID")
	protected String sessionContextID;
	@JsonProperty("transactionContextID")
	protected String transactionContextID;
	@JsonProperty("userNo")
	protected Long userNo;
	@JsonProperty("terminalId")
	protected String terminalId;
	@JsonProperty("reason")
	protected Reason reason;

}