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

    public static void main(String[] args) {
        System.out.println("***WELCOME!***");
        CalculatorRunner cui = new CalculatorRunner();
        cui.run();
        System.out.println("***HAVE A NICE DAY***");
    }

    /**
     * Runs UI and catches user's wrong input exceptions
     */
    private void run() {
        Calculator calc = null;
        do {
            try {
                calc = new Calculator(initialValueReader());
            } catch (WrongValueException e) {
                System.err.println("***" + e.getMessage() + "***");
            }
        }
        while (calc == null);
        printInfo();
        while (this.isRunning) {
            try {
                runCalculation(calc);
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
    private int initialValueReader() throws WrongValueException {
        System.out.println("Please enter the initial value.");
        String input = reader.next();
        valueCheck(input);
        return Integer.parseInt(input);
    }

    /**
     * @param input
     * @throws WrongValueException
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

    private void runCalculation(Calculator calc) throws WrongValueException, WrongCommandException {
        String input = reader.next();
        if (input.length() < 2) {
            throw new WrongCommandException();
        } else calculationMenu(calc, input);
    }

    private void calculationMenu(Calculator calc, String input) throws WrongValueException, WrongCommandException {
        char operation = input.charAt(0);
        String arg = input.substring(1);
        switch (operation) {
            case '+':
                valueCheck(arg);
                calc.plus(Integer.parseInt(arg));
                break;
            case '-':
                valueCheck(arg);
                calc.minus(Integer.parseInt(arg));
                break;
            case '*':
                valueCheck(arg);
                calc.multiple(Integer.parseInt(arg));
                break;
            case '/':
                valueCheck(arg);
                int parsedArg = Integer.parseInt(arg);
                if (parsedArg == 0) throw new WrongValueException("You can't divide by zero. Enter non-zero argument.");
                else calc.divide(parsedArg);
                break;
            default:
                commandMenu(calc, input);
                break;
        }
    }

    private void commandMenu(Calculator calc, String input) throws WrongCommandException {
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