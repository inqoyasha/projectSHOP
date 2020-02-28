package org.azamat.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(int quantity) {
        super("Available only: " + quantity);
    }
}
