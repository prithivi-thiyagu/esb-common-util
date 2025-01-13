package com.bandhanbank.esb.common.util.ExceptionHandler.Configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "exception.error")
public class ExceptionErrorCodeMapping {
    private Map<String, String> errorCodeMap;

    public Map<String, String> getErrorCodeMap() {
        return errorCodeMap;
    }

    public void setErrorCodeMap(Map<String, String> errorCodeMap) {
        this.errorCodeMap = errorCodeMap;
    }

    public String getErrorCode(Class<?> exceptionClass) {

        return errorCodeMap != null ? errorCodeMap.get(exceptionClass.getSimpleName()) : null;
    }
}


