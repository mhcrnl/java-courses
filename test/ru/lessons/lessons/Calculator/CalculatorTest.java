package ru.lessons.lessons.Calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Artva
 * @since 02/08/2015
 */
public class CalculatorTest {

    @Test
    public void testPlus() throws Exception {
        Calculator calculator = new Calculator(0);
        calculator.plus(5);
        assertEquals(5, calculator.getResult());
    }

    @Test
    public void testMinus() throws Exception {
        Calculator calculator = new Calculator(0);
        calculator.minus(5);
        assertEquals(-5, calculator.getResult());
    }

    @Test
    public void testMultiple() throws Exception {
        Calculator calculator = new Calculator(2);
        calculator.multiple(5);
        assertEquals(10, calculator.getResult());

    }

    @Test
    public void testDivide() throws Exception {
        Calculator calculator = new Calculator(6);
        calculator.divide(2);
        assertEquals(3, calculator.getResult());
    }

    @Test
    public void testSquare() throws Exception {
        Calculator calculator = new Calculator(0);
        calculator.square(5);
        assertEquals(25, calculator.getResult());
    }

    @Test
    public void testGetResult() throws Exception {
        Calculator calculator = new Calculator(5);
        assertEquals(5, calculator.getResult());
    }

    @Test
    public void testCleanResult() throws Exception {
        Calculator calculator = new Calculator(5);
        calculator.cleanResult();
        assertEquals(0, calculator.getResult());
    }
}