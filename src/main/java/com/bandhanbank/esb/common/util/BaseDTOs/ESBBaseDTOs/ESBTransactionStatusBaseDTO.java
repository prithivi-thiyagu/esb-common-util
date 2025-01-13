package com.bandhanbank.esb.common.util.BaseDTOs.ESBBaseDTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonRootName("TransactionStatus")
public class ESBTransactionStatusBaseDTO {

        @JsonProperty("IsOverriden")
        protected Boolean isOverriden;
        @JsonProperty("ReplyCode")
        protected String replyCode;
        @JsonProperty("SpReturnValue")
        protected String spReturnValue;
        @JsonProperty("ReplyText")
        protected String replyText;
        @JsonProperty("Memo")
        protected String memo;
        @JsonProperty("ExternalReferenceNo")
        protected String externalReferenceNo;
        @JsonProperty("IsServiceChargeApplied")
        protected String isServiceChargeApplied;
        @JsonProperty("ErrorCode")
        protected String errorCode;
        @JsonProperty("ExtendedReply")
        protected CDMExtendedReply extendedReply;
        @JsonProperty("ValidationErrors")
        protected List<CDMValidationErrors> validationErrors;
        @JsonProperty("Mode")
        protected String mode;
        @JsonProperty("OverrideCode")
        protected String overrideCode;
        @JsonProperty("Status")
        protected String status;
        @JsonProperty("OriginalTransactionStatus")
        protected String originalTransactionStatus;
        @JsonProperty("ExternalResponseCode")
        protected String externalResponseCode;
        @JsonProperty("CopyOverrideCode")
        protected String copyOverrideCode;
        @JsonProperty("FCYHangeHandlingApplied")
        protected Boolean fcyHangeHandlingApplied;
        @JsonProperty("UserReferenceNumber")
        protected String userReferenceNumber;

        public String getOverrideCode() {
                return overrideCode;
        }

        public void setOverrideCode(String overrideCode) {
                this.overrideCode = overrideCode;
        }

        public Boolean getOverriden() {
                return isOverriden;
        }

        public void setOverriden(Boolean overriden) {
                isOverriden = overriden;
        }

        public String getReplyCode() {
                return replyCode;
        }

        public void setReplyCode(String replyCode) {
                this.replyCode = replyCode;
        }

        public String getSpReturnValue() {
                return spReturnValue;
        }

        public void setSpReturnValue(String spReturnValue) {
                this.spReturnValue = spReturnValue;
        }

        public String getReplyText() {
                return replyText;
        }

        public void setReplyText(String replyText) {
                this.replyText = replyText;
        }

        public String getMemo() {
                return memo;
        }

        public void setMemo(String memo) {
                this.memo = memo;
        }

        public String getExternalReferenceNo() {
                return externalReferenceNo;
        }

        public void setExternalReferenceNo(String externalReferenceNo) {
                this.externalReferenceNo = externalReferenceNo;
        }

        public String getIsServiceChargeApplied() {
                return isServiceChargeApplied;
        }

        public void setIsServiceChargeApplied(String isServiceChargeApplied) {
                this.isServiceChargeApplied = isServiceChargeApplied;
        }

        public String getErrorCode() {
                return errorCode;
        }

        public void setErrorCode(String errorCode) {
                this.errorCode = errorCode;
        }

        public CDMExtendedReply getExtendedReply() {
                return extendedReply;
        }

        public void setExtendedReply(CDMExtendedReply extendedReply) {
                this.extendedReply = extendedReply;
        }

        public List<CDMValidationErrors> getValidationErrors() {
                return validationErrors;
        }

        public void setValidationErrors(List<CDMValidationErrors> validationErrors) {
                this.validationErrors = validationErrors;
        }

        public String getMode() {
                return mode;
        }

        public void setMode(String mode) {
                this.mode = mode;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }

        public String getOriginalTransactionStatus() {
                return originalTransactionStatus;
        }

        public void setOriginalTransactionStatus(String originalTransactionStatus) {
                this.originalTransactionStatus = originalTransactionStatus;
        }

        public String getExternalResponseCode() {
                return externalResponseCode;
        }

        public void setExternalResponseCode(String externalResponseCode) {
                this.externalResponseCode = externalResponseCode;
        }

        public String getCopyOverrideCode() {
                return copyOverrideCode;
        }

        public void setCopyOverrideCode(String copyOverrideCode) {
                this.copyOverrideCode = copyOverrideCode;
        }

        public Boolean getFcyHangeHandlingApplied() {
                return fcyHangeHandlingApplied;
        }

        public void setFcyHangeHandlingApplied(Boolean fcyHangeHandlingApplied) {
                this.fcyHangeHandlingApplied = fcyHangeHandlingApplied;
        }

        public String getUserReferenceNumber() {
                return userReferenceNumber;
        }

        public void setUserReferenceNumber(String userReferenceNumber) {
                this.userReferenceNumber = userReferenceNumber;
        }
}
