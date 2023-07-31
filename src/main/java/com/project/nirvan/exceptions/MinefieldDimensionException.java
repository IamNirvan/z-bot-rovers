package com.project.nirvan.exceptions;

public class MinefieldDimensionException extends RuntimeException {
    public MinefieldDimensionException(String message) {
        super(String.format("\nERROR [Minefield]: \n\t- %s", message));
    }
}
