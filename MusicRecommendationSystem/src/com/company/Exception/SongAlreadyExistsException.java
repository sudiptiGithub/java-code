package com.company.Exception;

public class SongAlreadyExistsException extends RuntimeException {
    public SongAlreadyExistsException(String s) {
        super(s);
    }
}
