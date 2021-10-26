package com.vulcuscr.calculator.model;

public class Calculator {
    Buffer valor1 = new Buffer();
    Buffer valor2 = new Buffer();
    int mode = 0;
    int operator = -1;

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public int getPriVal(){
        return valor1.getValue();
    }

    public int getSecVal(){
        return valor2.getValue();
    }

    public boolean hasOperator(){
        return operator!=-1;
    }

    public void bufferClearVal(){
      valor1.clear();
      valor2.clear();
    }

    public void addDigit(int val){
        if(!hasOperator()){
            valor1.addDigit(val);
        }
        else{
            valor2.addDigit(val);
        }
    }

    public int sum(int x, int y){
        return x + y;
    }

    public int mul(int x, int y){
        return x * y;
    }

    public int div(int x, int y){
        return x/y;
    }

    public int rest(int x, int y){
        return x - y;
    }

    public String priValBuff(){
        return valor1.getBuffer();
    }

    public String secValBuff(){
        return valor2.getBuffer();
    }

    public void doOperator(int operator){
        switch (operator){
            default:
                break;
            case 0:
                valor1.setValue(valor1.getValue() + valor2.getValue());
                break;
            case 1:
                valor1.setValue(valor1.getValue() - valor2.getValue());
                break;
            case 2:
                valor1.setValue(valor1.getValue() * valor2.getValue());
                break;
            case 3:
                valor1.setValue(valor1.getValue() / valor2.getValue());
                break;
        }
    }

}
