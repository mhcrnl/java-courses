package ru.lessons.lessons.Calculator;


import java.util.LinkedList;

/**
 * @author Artva
 * @since 05.08.2015 version 1.0
 */
class CalculatorHandler {
    private final Calculator calc = new Calculator();


    private double argConverter(String input) throws WrongValueException {
        char[] chars = input.toCharArray();
        boolean isPosMemoryArg = false;
        boolean isNegMemoryArg = false;
        boolean hasPoint = false;
        int i = 0;
        if (chars[i] == '-') {
            i++;
        }
        if (chars[i] == 'm') {
            i++;
            if (i == 2) isNegMemoryArg = true;
            else isPosMemoryArg = true;
            input = input.substring(i);
        }
        for (; i < chars.length; i++) {
            if (!(hasPoint)&&chars[i]=='.'){
                i++;
                hasPoint=true;
            }
            if (!(Character.isDigit(chars[i]))) {
                throw new WrongValueException();
            }
        }
        double result = Double.parseDouble(input);
        if (isPosMemoryArg) return getMemoryArg((int) result);
        if (isNegMemoryArg) return -getMemoryArg((int) result);
        else return result;
    }

    private double getMemoryArg(int index) throws WrongValueException {
        if (calc.getMemory().size() > index) return calc.getMemory().get(index);
        else throw new WrongValueException("There isn't argument witch such index in the memory");
    }

    private void addMemoryArg() {
        calc.addMemory(calc.getResult());
    }

    void switchCalculation(String input) throws WrongValueException, WrongCommandException {
        char operator = input.charAt(0);
        //checks for operator miss
        if (Character.isDigit(operator) || operator == 'm') {
            this.calc.plus(argConverter(input));
            printResult();
            return;
        }
        String arg = input.substring(1);
        switch (operator) {
            case '+':
                this.calc.plus(argConverter(arg));
                printResult();
                break;
            case '-':
                this.calc.minus(argConverter(arg));
                printResult();
                break;
            case '*':
                this.calc.multiple(argConverter(arg));
                printResult();
                break;
            case '/':
                //checks for dividing by zero
                if (argConverter(arg) == 0)
                    throw new WrongValueException("You can't divide by zero. Enter non-zero argument.");
                else {
                    this.calc.divide(argConverter(arg));
                    printResult();
                }
                break;
            default:
                switchCommand(input);
                break;
        }
    }

    private void switchCommand(String input) throws WrongCommandException {
        switch (input) {
            case "square":
                calc.square(calc.getResult());
                printResult();
                break;
            case "reset":
                calc.cleanResult();
                System.out.println("***Result has been reset***");
                break;
            case "sm":
                addMemoryArg();
                double arg = calc.getMemory().getLast();
                System.out.println("***Argument with value \"" +
                        arg + "\" was added to memory as \"m" + calc.getMemory().indexOf(arg) + "\"");
                calc.cleanResult();
                break;
            case "rm":
                calc.resetMemory();
                System.out.println("***Memory has been reset");
                break;
            case "pm":
                printMemory();
                break;
            case "exit":
                calc.stop();
                break;
            default:
                throw new WrongCommandException();
        }
    }

    private void printMemory() {
        LinkedList<Double> memory = calc.getMemory();
        System.out.println("***");
        for (int i = 0; i < memory.size(); i++) {
            System.out.println("m" + i + " = " + memory.get(i));
        }
        System.out.println("***");
    }

    public Calculator getCalculator() {
        return this.calc;
    }

    private void printResult() {
        System.out.println("***Result is \"" + calc.getResult() + "\"***");
    }
}
