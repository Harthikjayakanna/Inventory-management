package com.inventory.administration.Exception;

public class IDnotFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        // TODO Auto-generated method stub
        return "Id Not Found";
    }
}
