package com.vulcuscr.calculator.model;

public class Buffer {
    int value = 0;
    String buffer="";

    public void addDigit(int value){
        buffer = buffer + value;
    }

    public int getValue(){
        if(!buffer.isEmpty()){
            value = Integer.parseInt(buffer);
            clear();
        }
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public String getBuffer(){
        return buffer;
    }

    public void clear(){
        buffer = "";
    }

    public void reset(){
        value = 0;
        clear();
    }

}
