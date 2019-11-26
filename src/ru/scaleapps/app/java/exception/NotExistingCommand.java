package ru.scaleapps.app.java.exception;

public class NotExistingCommand extends RuntimeException {
    @Override
    public String toString() {
        return "Not existing command";
    }
}
