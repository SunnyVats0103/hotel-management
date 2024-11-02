package com.dev.nistha.errorhandler;

public class NoStaffFoundException extends Throwable {

    public NoStaffFoundException(String message) {
        super(String.format("Error: %s", message));
    }
}
