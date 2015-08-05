package ru.lessons.lessons.Calculator;

import java.util.Scanner;

/**
 * Created by Надежда on 05.08.2015.
 */
public class InteractiveRunner {
    private final Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("***WELCOME!***" +
                "\n Please enter initial value");
        InteractiveRunner ir = new InteractiveRunner();
        ir.run();
        System.out.println("***HAVE A NICE DAY***");
    }

    private void run() {
        CalculatorHandler handler = null;
        while(handler==null){
            try {
                handler = new CalculatorHandler(reader.next());
            } catch (WrongValueException e) {
                System.err.println("***" + e.getMessage() + "***");
            }
        }
        while (handler.getCalculator().isRunning()){
            try {
                handler.switchCalculation(reader.next());
                System.out.println("***Result is " + handler.getCalculator().getResult() + "***");
            } catch (WrongCommandException | WrongValueException e) {
                System.err.println("***" + e.getMessage() + "***");
            }
        }
    }
}
