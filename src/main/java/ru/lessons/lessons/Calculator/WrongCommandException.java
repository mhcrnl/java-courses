package ru.lessons.lessons.Calculator;

/**
 * Use to except wrong command input
 * @author Artva
 * @since 02.08.2015 version 1.0
 * @since 06.08.2015 version 1.1
 * works with Calculator 2.0
 */

class WrongCommandException extends Exception {
    public WrongCommandException() {
        super("You have entered wrong command. Please try again");
    }
}
