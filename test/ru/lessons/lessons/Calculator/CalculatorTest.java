package ru.lessons.lessons.Calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Artva
 * @since 26/07/2015
 */
public class CalculatorTest {
    Calculator calc = new Calculator(5);
    @Test
    public void testCalculate() throws Exception {
        calc.calculate("/2");
        assertEquals(2, calc.getResult());
        calc.calculate("*4");
        assertEquals(8, calc.getResult());
        calc.calculate("+4");
        assertEquals(12, calc.getResult());
        calc.calculate("-3");
        assertEquals(9,calc.getResult());
    }

    @Test
    public void testSquare() throws Exception {
        calc.square(5);
        assertEquals(25,calc.getResult());
    }

    @Test
    public void testGetResult() throws Exception {
        assertEquals(5,calc.getResult());
    }

    @Test
    public void testCleanResult() throws Exception {
        calc.cleanResult();
        assertEquals(0,calc.getResult());
    }
}