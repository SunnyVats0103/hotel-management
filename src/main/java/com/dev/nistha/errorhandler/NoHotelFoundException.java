package com.dev.nistha.errorhandler;

public class NoHotelFoundException extends Throwable {

    public NoHotelFoundException(String s) {
        super(String.format("Error: %s", s));
    }
}
