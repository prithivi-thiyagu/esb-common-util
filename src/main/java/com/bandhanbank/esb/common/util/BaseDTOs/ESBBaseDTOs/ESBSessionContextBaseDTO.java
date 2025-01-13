package com.bandhanbank.esb.common.util.BaseDTOs.ESBBaseDTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonRootName("SessionContext")
public class ESBSessionContextBaseDTO {

	@JsonProperty("SessionTicket")
	protected String sessionTicket;

	@JsonProperty("BankCode")
	protected Integer bankCode;

	@JsonProperty("TransactionBranch")
	protected Integer transactionBranch;

	@JsonProperty("OverridenWarnings")
	protected String overridenWarnings;

	@JsonProperty("LocalDateTimeText")
	protected String localDateTimeText;

	@JsonProperty("ExternalReferenceNo")
	protected String externalReferenceNo;

	@JsonProperty("UserReferenceNumber")
	protected String userReferenceNumber;

	@JsonProperty("OriginalReferenceNo")
	protected String originalReferenceNo;

	@JsonProperty("PostingDateText")
	protected String postingDateText;

	@JsonProperty("ValueDateText")
	protected String valueDateText;

	@JsonProperty("ExternalBatchNumber")
	protected Long externalBatchNumber;

	@JsonProperty("ExternalSystemAuditTrailNumber")
	protected Long externalSystemAuditTrailNumber;

	@JsonProperty("Channel")
	protected String channel;

	@JsonProperty("UserId")
	protected String userId;

	@JsonProperty("SupervisorContext")
	protected CDMSupervisorContext supervisorContext;

	@JsonProperty("TellerContext")
	protected CDMTellerContext tellerContext;

	@JsonProperty("ServiceCode")
	protected String serviceCode;

	@JsonProperty("ElectronicJournalOperationType")
	protected String electronicJournalOperationType;

	@JsonProperty("BrnPostingDateText")
	protected String brnPostingDateText;

	@JsonProperty("AuditComments")
	protected String auditComments;

	@JsonProperty("ExternalUserId")
	protected String externalUserId;

	@JsonProperty("ExternalBranchCode")
	protected String externalBranchCode;

	@JsonProperty("SessionContextID")
	protected String sessionContextID;

	@JsonProperty("TransactionContextID")
	protected String transactionContextID;

	@JsonProperty("UserNo")
	protected Long userNo;

	@JsonProperty("TerminalId")
	protected String terminalId;

	@JsonProperty("Reason")
	protected CDMReason reason;

}