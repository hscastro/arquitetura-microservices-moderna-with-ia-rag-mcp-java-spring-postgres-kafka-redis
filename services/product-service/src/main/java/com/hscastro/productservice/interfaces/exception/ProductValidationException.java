package com.hscastro.productservice.interfaces.exception;


public class ProductValidationException extends RuntimeException {

    public ProductValidationException(String message) {
        super(message);
    }

}