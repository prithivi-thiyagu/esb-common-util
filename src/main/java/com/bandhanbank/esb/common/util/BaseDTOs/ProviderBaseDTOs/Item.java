package com.bandhanbank.esb.common.util.BaseDTOs.ProviderBaseDTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class Item {
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

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }
}
