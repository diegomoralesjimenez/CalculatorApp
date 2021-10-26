package com.vulcuscr.calculator.controller;

import com.vulcuscr.calculator.model.Calculator;

public class CalculatorController {

   Calculator calculator1 = new Calculator();;

    public void addCal(int operator1){
        calculator1.addDigit(operator1);
    }

    public boolean seeOp(){
        return calculator1.hasOperator();
    }

    public String primBuff(){
        return calculator1.priValBuff();
    }

    public String secBuff(){
        return calculator1.secValBuff();
    }

    public int primVal(){
        return calculator1.getPriVal();
    }

    public int secVal(){
        return calculator1.getSecVal();
    }

    public int sum(int x,int y){
       return calculator1.sum(x,y);
    }
    public int rest(int x,int y){
        return calculator1.rest(x,y);
    }
    public int mul(int x,int y){
        return calculator1.mul(x,y);
    }
    public int div(int x,int y){
        return calculator1.div(x,y);
    }

    public void useMode(int x){
        calculator1.setOperator(x);
    }

    public int getMode(){
        return calculator1.getOperator();
    }

    public void clearBuff(){
        calculator1.bufferClearVal();
    }

    public CalculatorController(){
    }


    private static CalculatorController instance;


    public static CalculatorController getInstance() {
        if(instance == null){
            instance = new CalculatorController();
        }
        return instance;
    }


}
