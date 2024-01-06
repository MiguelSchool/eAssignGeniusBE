package org.example.eassigngeniusbe.share.customException;

public class SchoolClassNotFoundException extends RuntimeException {
    public SchoolClassNotFoundException(final Long id) {
        super( "school class with id " + id + "not found!");
    }
}
