package com.vulcuscr.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

import com.vulcuscr.calculator.model.Buffer;

public class BufferTest {

    @Test
    public void digitTest(){
        Buffer buffer = new Buffer();
        buffer.addDigit(2);
        assertTrue( 2 == buffer.getValue());
    }


}
