package ru.lessons.lessons.Calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Надежда on 25.07.2015.
 */
public class CalculatorTest {

    @Test
    public void testCalculate() throws Exception {
        Calculator calc = new Calculator(5);
        calc.calculate("/2");

        assertEquals(2,calc.getResult());

    }
}