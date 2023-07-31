package com.project.nirvan.exceptions;

public class IllegalRoverTransformationException extends ZBotRoverException {
    public IllegalRoverTransformationException(String message) {
        super(String.format("\nERROR [Rover]: \n\t - %s", message));
    }

    public IllegalRoverTransformationException(String roverId, String message) {
        super(String.format("\nERROR [Rover %s]: \n\t - %s", roverId, message));
    }
}
