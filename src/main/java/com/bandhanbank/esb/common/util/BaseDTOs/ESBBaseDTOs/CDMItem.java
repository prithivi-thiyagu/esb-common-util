package com.bandhanbank.esb.common.util.BaseDTOs.ESBBaseDTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CDMItem {
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

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }
}
