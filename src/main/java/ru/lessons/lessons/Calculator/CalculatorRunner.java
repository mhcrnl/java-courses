package ru.lessons.lessons.Calculator;

import java.util.Scanner;

/**
 * Runner of calculator's UI
 *
 * @author Artva
 * @version 1.1
 * @since 29/07/2015
 */
public class CalculatorRunner {
    private final Scanner reader = new Scanner(System.in);
    private boolean isRunning = true;
    private final Calculator calc;
    private String input;


    public CalculatorRunner() throws WrongValueException {
        this.calc = new Calculator(readInitialValue());
    }

    public static void main(String[] args) {
        System.out.println("***WELCOME!***" +
                "\n Please enter initial value");
        CalculatorRunner cr = null;
        while (cr == null) {
            try {
                cr = new CalculatorRunner();
                cr.run();
            } catch (WrongValueException e) {
                System.err.println("***" + e.getMessage() + "***");
            }
        }
        System.out.println("***HAVE A NICE DAY***");
    }

    /**
     * Creates Calculator object with initial value, which is read from initialValueReader,
     * and runs calculation process.     *
     * Catches user's wrong input exceptions.
     */
    private void run() {

        printInfo();
        while (this.isRunning) {
            try {
                runCalculation();
                System.out.println("***Result is " + calc.getResult() + "***");
            } catch (WrongCommandException | WrongValueException e) {
                System.err.println("***" + e.getMessage() + "***");
            }
        }
    }

    /**
     * Prints instruction of UI
     */
    private void printInfo() {
        System.out.println("Please enter sign of operation and argument with no separation" +
                "\n For example, entering \"/15\" will divide result by 15" +
                "\n Also you can use this input commands to do appropriate operation:" +
                "\n \"square\", \"reset\", \"exit\"");
    }

    /**
     * Reads user's input and checks it's
     *
     * @return input as Integer if value check was successful
     * @throws WrongValueException if value check failed
     */
    public int readInitialValue() throws WrongValueException {
        input = reader.next();
        valueCheck(input);
        return Integer.parseInt(input);
    }

    /**
     * Checks that param is a number and don't exceed the limit values of Integer
     *
     * @throws WrongValueException if param isn't a number or it's out of Integer's value range
     */
    private void valueCheck(String input) throws WrongValueException {
        for (char ch : input.toCharArray()) {
            if (!(Character.isDigit(ch))) {
                throw new WrongValueException();
            }
        }
        long value = Long.parseLong(input);
        if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) throw new WrongValueException();
    }

    private void runCalculation() throws WrongValueException, WrongCommandException {
        input = reader.next();
        if (input.length() < 2) {
            throw new WrongCommandException();
        } else calculationMenu();
    }

    private void calculationMenu() throws WrongValueException, WrongCommandException {
        char operation = input.charAt(0);
        String arg = input.substring(1);
        switch (operation) {
            case '+':
                valueCheck(arg);
                calc.plus(Integer.parseInt(input));
                break;
            case '-':
                valueCheck(arg);
                calc.minus(Integer.parseInt(input));
                break;
            case '*':
                valueCheck(arg);
                calc.multiple(Integer.parseInt(input));
                break;
            case '/':
                valueCheck(arg);
                int parsedArg = Integer.parseInt(arg);
                if (parsedArg == 0) throw new WrongValueException("You can't divide by zero. Enter non-zero argument.");
                else calc.divide(parsedArg);
                break;
            default:
                commandMenu();
                break;
        }
    }

    private void commandMenu() throws WrongCommandException {
        switch (input) {
            case "square":
                calc.square(calc.getResult());
                break;
            case "reset":
                calc.cleanResult();
                break;
            case "exit":
                this.isRunning = false;
                break;
            default:
                throw new WrongCommandException();
        }
    }
}