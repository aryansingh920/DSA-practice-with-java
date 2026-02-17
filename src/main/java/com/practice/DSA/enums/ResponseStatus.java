package com.practice.DSA.enums;

import org.springframework.http.HttpStatus;

public enum ResponseStatus {

    SUCCESS(HttpStatus.OK, "success"),
    CREATED(HttpStatus.CREATED, "created"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "bad request"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "not found"),
    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "internal error");

    private final HttpStatus httpStatus;
    private final String message;

    ResponseStatus(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public int getCode() {
        return httpStatus.value();
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
