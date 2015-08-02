package ru.lessons.lessons.Calculator;

/**
 * Created by Надежда on 30.07.2015.
 */
public class WrongCommandException extends Exception {
    public WrongCommandException() {
        super("You have entered wrong command. Please try again");
    }
}
