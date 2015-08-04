package ru.lessons.lessons.Calculator;

/**
 * @author Artva
 * @since 2724
 */
class WrongCommandException extends Exception {
    public WrongCommandException() {
        super("You have entered wrong command. Please try again");
    }
}
