package ru.lessons.lessons.Calculator;

/**
 * Created by Надежда on 02.08.2015.
 */
public class WrongValueException extends Exception {
    public WrongValueException() {
        super("Entered argument must be a NUMBER between " + Integer.MIN_VALUE + " and " + Integer.MAX_VALUE + ". Try again.");
    }

    public WrongValueException(String message) {
        super(message);
    }
}
