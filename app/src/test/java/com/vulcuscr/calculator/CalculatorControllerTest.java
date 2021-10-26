package com.vulcuscr.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

import com.vulcuscr.calculator.controller.CalculatorController;

public class CalculatorControllerTest {

    @Test
    public void additionTest(){
        CalculatorController instance = CalculatorController.getInstance();
        assertTrue(4 == instance.sum(2,2));
    }

    @Test
    public void substractionTest(){
        CalculatorController instance = CalculatorController.getInstance();
        assertTrue( 4 == instance.rest(6,2));
    }

    @Test
    public void multiplyTest(){
        CalculatorController instance = CalculatorController.getInstance();
        assertTrue( 8 == instance.mul( 4, 2));
    }

    @Test
    public void divisionTest(){
        CalculatorController instance = CalculatorController.getInstance();
        assertTrue(  2 == instance.div(4,2));
    }

    @Test
    public void modeTest(){
    CalculatorController instance = CalculatorController.getInstance();
    instance.useMode(2);
    assertTrue(2 == instance.getMode());
    }

}
