package ru.lessons.lessons.Calculator;

/**
 * @author Artva
 * @version 1.2
 * @since 15/07/2015
 */
class Calculator {
    /**
     * current calculation result
     */
    private int result;

    /**
     * @param initialValue Setting first value of result
     */
    public Calculator(int initialValue) {
        this.result = initialValue;
    }

    /**
     * @param args Array of input arguments, which will be added to result
     */
    public void plus(int... args) {
        for (int arg : args) {
            this.result += arg;
        }
    }

    /**
     * @param args Array of arguments, which will be deducted from result
     */
    public void minus(int... args) {
        for (int arg : args) {
            this.result -= arg;
        }
    }

    /**
     * @param args Array of arguments, which will be multiplied to result
     */
    public void multiple(int... args) {
        for (int arg : args) {
            this.result *= arg;
        }
    }

    /**
     * @param args Array of arguments, which will be divisible by result
     */
    public void divide(int... args) {
        for (int arg : args) {
            this.result /= arg;
        }
    }

    /**
     * @param arg Argument, which will be squared
     */
    void square(int arg) {
        this.result = arg * arg;
    }

    /**
     * @return current calculation result
     */
    public int getResult() {
        return this.result;
    }

    /**
     * reset result to 0
     */
    public void cleanResult() {
        this.result = 0;
        System.out.println("***The result has been reset***");
    }

}
