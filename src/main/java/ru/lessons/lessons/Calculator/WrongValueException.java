package ru.lessons.lessons.Calculator;

/**
 * Use to except wrong number input
 * @author Artva
 * @since 02.08.2015 version 1.0
 * @since 06.08.2015 version 1.1
 * works with Calculator 2.0
 */

class WrongValueException extends Exception {
    public WrongValueException() {
        super("Value must be a NUMBER between " + Double.MIN_VALUE + " and " + Double.MAX_VALUE + ". Try again.");
    }

    public WrongValueException(String message) {
        super(message);
    }
}
