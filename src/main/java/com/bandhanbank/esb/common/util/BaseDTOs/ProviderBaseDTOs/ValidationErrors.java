package com.bandhanbank.esb.common.util.BaseDTOs.ProviderBaseDTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class ValidationErrors {
    @JsonProperty("objectName")
    protected String objectName;
    @JsonProperty("attributeName")
    protected String attributeName;
    @JsonProperty("attributeValue")
    protected String attributeValue;
    @JsonProperty("errorCode")
    protected String errorCode;
    @JsonProperty("errorMessage")
    protected String errorMessage;
    @JsonProperty("methodName")
    protected String methodName;
    @JsonProperty("applicableAttributes")
    protected String applicableAttributes;
    @JsonProperty("item")
    protected List<Item> item;

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

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
}
