package com.bandhanbank.esb.common.util.BaseDTOs.ESBBaseDTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CDMValidationErrors {
    @JsonProperty("ObjectName")
    protected String objectName;
    @JsonProperty("AttributeName")
    protected String attributeName;
    @JsonProperty("AttributeValue")
    protected String attributeValue;
    @JsonProperty("ErrorCode")
    protected String errorCode;
    @JsonProperty("ErrorMessage")
    protected String errorMessage;
    @JsonProperty("MethodName")
    protected String methodName;
    @JsonProperty("ApplicableAttributes")
    protected String applicableAttributes;
    @JsonProperty("Item")
    protected List<CDMItem> item;

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getApplicableAttributes() {
        return applicableAttributes;
    }

    public void setApplicableAttributes(String applicableAttributes) {
        this.applicableAttributes = applicableAttributes;
    }

    public List<CDMItem> getItem() {
        return item;
    }

    public void setItem(List<CDMItem> item) {
        this.item = item;
    }
}
