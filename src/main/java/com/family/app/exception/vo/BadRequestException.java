package com.family.app.exception.vo;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
