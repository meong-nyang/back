package com.meongnyang.shop.exception;

public class NotFoundProductException extends RuntimeException {

    public NotFoundProductException(String message) {
        super(message);
    }
}
