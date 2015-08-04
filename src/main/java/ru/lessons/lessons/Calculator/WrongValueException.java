package ru.lessons.lessons.Calculator;

/**
 * @author Artva
 * @since 02.08.2015 version 1.0
 */
@SuppressWarnings("SameParameterValue")
class WrongValueException extends Exception {
    public WrongValueException() {
        super("Entered argument must be a NUMBER between " + Integer.MIN_VALUE + " and " + Integer.MAX_VALUE + ". Try again.");
    }

    public WrongValueException(String message) {
        super(message);
    }
}
