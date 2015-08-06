package ru.lessons.lessons.Calculator;

import java.util.Scanner;

/**
 * InteractiveRunner starts CalculatorHandler,
 * takes user's input; if input is incorrect -
 * catches WrongValue and WrongCommand exceptions from handler;
 * also print opening instructions.
 * Use to work with Calculator 2.0.
 *
 * @author Artva
 * @since 05.08.2015 version 1.0
 */
public class InteractiveRunner {
    /**
     * Use to take user's input (commands, args, etc.)
     */
    private final Scanner reader = new Scanner(System.in);

    /**
     * Initialize and start InteractRunner.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("***WELCOME!***");
        InteractiveRunner ir = new InteractiveRunner();
        ir.run();
        System.out.println("***HAVE A NICE DAY***");
    }

    /**
     * Creates CalculatorHandler-Object, prints opening instructions,
     * catches WrongValue and WrongCommand exceptions.
     */
    private void run() {
        CalculatorHandler handler = new CalculatorHandler();
        printInfo();
        while (handler.getCalculator().isRunning()) {
            try {
                handler.switchCalculation(reader.next());
            } catch (WrongCommandException | WrongValueException e) {
                System.err.println("***" + e.getMessage() + "***");
            }
        }
    }

    /**
     * Prints opening instructions.
     */
    private void printInfo() {
        System.out.println("Enter operator and argument." +
                "\nExample: \"/4\" will divide result by 4." +
                "\nEntering argument without operation sign will add it to result." +
                "\nAlso you can use commands:" +
                "\n\"square\" - squares current result" +
                "\n\"reset\" - resets current result" +
                "\n\"sm\" - saves current result to memory and resets result" +
                "\n\"rm\" - resets current memory" +
                "\n\"pm\" - prints current memory" +
                "\n\"exit\" - quit program");
    }
}
