package ru.lessons.lessons.Calculator;


/**
 * @author Artva
 * @since 05.08.2015 version 1.0
 */
public class CalculatorHandler {

    public double converter(String input) throws WrongValueException {
        char[] chars = input.toCharArray();
        int i = 0;
        if (chars[0] == 'm') {
            converter(input.substring(1));
            return getResultMemory(Double.parseDouble(input.substring(1)));
            if (chars[i] == 'm' || chars[0] == '-') {
                i++;
            }
            for (; i < chars.length; i++) {
                if (!(Character.isDigit(chars[i]))) {
                    throw new WrongValueException();
                }
            }

        }
        return Double.parseDouble(input);
    }

    private void switchCalculation(Calculator calc) throws WrongValueException, WrongCommandException {
        char operation = input.charAt(0);
        String arg = input.substring(1);
        switch (operation) {
            case '+':
                calc.plus(convertToNumber(arg));
                break;
            case '-':
                calc.minus(convertToNumber(arg));
                break;
            case '*':
                calc.multiple(convertToNumber(arg));
                break;
            case '/':
                int parsedArg = convertToNumber(arg);
                if (parsedArg == 0) throw new WrongValueException("You can't divide by zero. Enter non-zero argument.");
                else calc.divide(parsedArg);
                break;
            default:
                commandMenu();
                break;
        }
    }
}
