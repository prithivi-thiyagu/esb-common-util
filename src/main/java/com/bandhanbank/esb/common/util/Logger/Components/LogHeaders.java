package com.bandhanbank.esb.common.util.Logger.Components;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
public class LogHeaders {
    private String version;
    private String function;
    private String domain;
    private String channelID;
    private String requestUUID;
    private String messageID;
    private String userID;
    private String serviceCategory;
    private String logType;
    private String logLevel;
    private LocalDateTime timestamp;

    private LogEnvelopeParameters logEnvelopeParameters;

    @Autowired
    public LogHeaders(LogEnvelopeParameters logEnvelopeParameters){
        this.serviceCategory = "ESB";
        this.version = logEnvelopeParameters.getVersion();
        this.function = logEnvelopeParameters.getFunction();
        this.domain = logEnvelopeParameters.getDomain();
        this.timestamp = LocalDateTime.now();
        this.logLevel = logEnvelopeParameters.getLogLevel();
        this.logType = logEnvelopeParameters.getLogType();

        Map<String,String> headers = logEnvelopeParameters.getHeaders();

        if(headers!=null) {
            this.channelID = headers.get("x-channel-id");
            this.requestUUID = headers.get("x-session-id");
            this.messageID = headers.get("x-message-id");
            this.userID = headers.get("x-user-id");
        }
    }

    @Override
    public String toString() {
        return "Version: '" + this.getVersion() +
                "', Function: '" + this.getFunction() +
                "', Domain: '" + this.getDomain() +
                "', ChannelID: '" + this.getChannelID() +
                "', RequestUUID: '" + this.getRequestUUID() +
                "', MessageID: '" + this.getMessageID() +
                "', UserId: '" + this.getUserID() +
                "', ServiceCategory: '" + this.getServiceCategory() +
                "', LogType: '" + this.getLogType() +
                "', LogLevel: '" + this.getLogLevel() +
                "', Timestamp: '" + this.getTimestamp() +
                "'";
    }
}