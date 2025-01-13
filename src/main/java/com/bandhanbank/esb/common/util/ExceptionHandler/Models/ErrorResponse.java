package com.bandhanbank.esb.common.util.ExceptionHandler.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;

//@NoArgsConstructor
//@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class ErrorResponse {
    private int statusCode;  // Status code (HTTP status or custom code)
    private Message message;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
