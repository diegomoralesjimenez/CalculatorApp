package com.vulcuscr.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

import com.vulcuscr.calculator.model.Calculator;

public class CalculatorTest {
    @Test
    public void digitTest(){
        Calculator calculator = new Calculator();
        calculator.addDigit(15);
        assertTrue(15== calculator.getPriVal());
    }

    @Test
    public void digitSecTest(){
        Calculator calculator = new Calculator();
        calculator.setOperator(2);
        calculator.addDigit(10);
        assertTrue(10== calculator.getSecVal());
    }

    @Test
    public void digitResTest(){
        Calculator calculator = new Calculator();
        calculator.addDigit(15);
        calculator.setOperator(2);
        calculator.addDigit(10);
        calculator.doOperator(2);
        assertTrue(150== calculator.getPriVal());
    }

}
