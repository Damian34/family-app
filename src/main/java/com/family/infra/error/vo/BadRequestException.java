package com.family.infra.error.vo;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
