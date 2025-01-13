package com.bandhanbank.esb.common.util.BaseDTOs.ProviderBaseDTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("transactionStatus")
public class FCCTransactionStatusBaseDTO {

        @JsonProperty("isOverriden")
        protected Boolean isOverriden;
        @JsonProperty("replyCode")
        protected String replyCode;
        @JsonProperty("spReturnValue")
        protected String spReturnValue;
        @JsonProperty("replyText")
        protected String replyText;
        @JsonProperty("memo")
        protected String memo;
        @JsonProperty("externalReferenceNo")
        protected String externalReferenceNo;
        @JsonProperty("isServiceChargeApplied")
        protected String isServiceChargeApplied;
        @JsonProperty("errorCode")
        protected String errorCode;
        @JsonProperty("extendedReply")
        protected ExtendedReply extendedReply;
        @JsonProperty("validationErrors")
        protected List<ValidationErrors> validationErrors;
        @JsonProperty("mode")
        protected String mode;
        @JsonProperty("overrideCode")
        protected String overrideCode;
        @JsonProperty("status")
        protected String status;
        @JsonProperty("originalTransactionStatus")
        protected String originalTransactionStatus;
        @JsonProperty("externalResponseCode")
        protected String externalResponseCode;
        @JsonProperty("copyOverrideCode")
        protected String copyOverrideCode;
        @JsonProperty("FCYHangeHandlingApplied")
        protected Boolean fcyHangeHandlingApplied;
        @JsonProperty("userReferenceNumber")
        protected String userReferenceNumber;


        public String getExternalReferenceNo() {
                return externalReferenceNo;
        }

        public void setExternalReferenceNo(String externalReferenceNo) {
                this.externalReferenceNo = externalReferenceNo;
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

        public ExtendedReply getExtendedReply() {
                return extendedReply;
        }

        public void setExtendedReply(ExtendedReply extendedReply) {
                this.extendedReply = extendedReply;
        }

        public List<ValidationErrors> getValidationErrors() {
                return validationErrors;
        }

        public void setValidationErrors(List<ValidationErrors> validationErrors) {
                this.validationErrors = validationErrors;
        }

        public String getMode() {
                return mode;
        }

        public void setMode(String mode) {
                this.mode = mode;
        }

        public String getOverrideCode() {
                return overrideCode;
        }

        public void setOverrideCode(String overrideCode) {
                this.overrideCode = overrideCode;
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
