package org.example.eassigngeniusbe.share.customException;

public class GradleLevelNotFoundException extends RuntimeException{
    public GradleLevelNotFoundException(final String message) {
        super(message);
    }
}
