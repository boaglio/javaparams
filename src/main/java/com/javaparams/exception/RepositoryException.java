package com.javaparams.exception;

public class RepositoryException extends Exception {

    private static final long serialVersionUID = 922413944326188778L;

    public RepositoryException(String message) {
        super("Error on handling: " + message);
    }
}
