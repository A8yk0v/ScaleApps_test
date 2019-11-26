package ru.scaleapps.app.java.exception;

public class IncorrectParameters extends RuntimeException {
    @Override
    public String getMessage() {
        return "Incorrect parameters";
    }

    @Override
    public String toString() {
        return "Incorrect parameters";
    }
}
