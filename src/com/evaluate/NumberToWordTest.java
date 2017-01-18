package com.evaluate;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by vishalsharma on 18/01/2017.
 */
public class NumberToWordTest {

    @Test
    public void testSingleDigits(){
        NumberToWord numberToWord = new NumberToWord();
        Map<Integer, String> numMap = new HashMap<Integer, String>();
        numMap.put(1, "one");
        numMap.put(2, "two");
        numMap.put(3, "three");
        numMap.put(4, "four");
        numMap.put(5, "five");
        numMap.put(6, "six");
        numMap.put(7, "seven");
        numMap.put(8, "eight");
        numMap.put(9, "nine");
        numMap.forEach((key,val) -> assertTrue(numberToWord.toWord(key).equals(val)));
    }

}