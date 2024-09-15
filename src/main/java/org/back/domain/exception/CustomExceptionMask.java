package org.back.domain.exception;

import org.springframework.http.HttpStatus;

public class CustomExceptionMask {

    private HttpStatus status;
    private String message;

    public CustomExceptionMask() {}

    public CustomExceptionMask(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
