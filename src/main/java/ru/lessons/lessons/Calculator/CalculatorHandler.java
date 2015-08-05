package ru.lessons.lessons.Calculator;


/**
 * @author Artva
 * @since 05.08.2015 version 1.0
 */
public class CalculatorHandler {
    private final Calculator calc;

    public CalculatorHandler(String initialValue) throws WrongValueException {
        this.calc = new Calculator(argConverter(initialValue));
    }

    public double argConverter(String input) throws WrongValueException {
        char[] chars = input.toCharArray();
        int i = 0;
        if (chars[0] == 'm') {
            return getMemoryArg(argConverter(input.substring(1)));
        }
        if (chars[0] == '-') {
            i++;
        }
        for (; i < chars.length; i++) {
            if (!(Character.isDigit(chars[i]))) {
                throw new WrongValueException();
            }
        }
        return Double.parseDouble(input);
    }

    private double getMemoryArg(double index) throws WrongValueException {
        if (calc.getMemory().size() > index) return calc.getMemory().get((int) index);
        else throw new WrongValueException("There isn't argument witch such index in the memory");
    }

    public void addMemoryArg() {
        calc.addMemory(calc.getResult());
    }

    void switchCalculation(String input) throws WrongValueException, WrongCommandException {
        char operation = input.charAt(0);
        String arg = input.substring(1);
        switch (operation) {
            case '+':
                this.calc.plus(argConverter(arg));
                break;
            case '-':
                this.calc.minus(argConverter(arg));
                break;
            case '*':
                this.calc.multiple(argConverter(arg));
                break;
            case '/':
                if (argConverter(arg) == 0) throw new WrongValueException("You can't divide by zero. Enter non-zero argument.");
                else this.calc.divide(argConverter(arg));
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
                break;
            case "reset":
                calc.cleanResult();
                break;
            case "ms":
                addMemoryArg();
                calc.cleanResult();
                break;
            case "exit":
                calc.stop();
                break;
            default:
                throw new WrongCommandException();
        }
    }
    public Calculator getCalculator(){
        return this.calc;
    }

}
