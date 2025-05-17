package com.gabriel.springrestspecialist.domain.exception;

public class EntityAlreadyInUseException extends RuntimeException {
    public EntityAlreadyInUseException(String message) {
        super(message);
    }
}
