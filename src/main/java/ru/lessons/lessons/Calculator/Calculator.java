package ru.lessons.lessons.Calculator;

import java.util.LinkedList;

/**
 * @author Artva
 * @since 05.08.2015 version 1.1
 * Changelist:
 * - works with double;
 * - works with memory;
 */
class Calculator {
    /**
     * current calculation result
     */
    private double result = 0;
    private boolean isRunning = true;
    private LinkedList<Double> memory = new LinkedList<>();

    /**
     * @param args Array of input arguments, which will be added to result
     */
    public void plus(double... args) {
        for (double arg : args) {
            this.result += arg;
        }
    }

    /**
     * @param args Array of arguments, which will be deducted from result
     */
    public void minus(double... args) {
        for (double arg : args) {
            this.result -= arg;
        }
    }

    /**
     * @param args Array of arguments, which will be multiplied to result
     */
    public void multiple(double... args) {
        for (double arg : args) {
            this.result *= arg;
        }
    }

    /**
     * @param args Array of arguments, which will be divisible by result
     */
    public void divide(double... args) {
        for (double arg : args) {
            this.result /= arg;
        }
    }

    /**
     * @param arg Argument, which will be squared
     */
    void square(double arg) {
        this.result = arg * arg;
    }

    /**
     * @return current calculation result
     */
    public double getResult() {
        return this.result;
    }

    /**
     * reset result to 0
     */
    public void cleanResult() {
        this.result = 0;
        System.out.println("***The result has been reset***");
    }

    public void addMemory(double arg) {
        this.memory.add(arg);
    }

    public LinkedList<Double> getMemory() {
        return this.memory;
    }

    public void resetMemory() {
        this.memory = new LinkedList<>();
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void stop() {
        this.isRunning = false;
    }
}
