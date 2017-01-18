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

    @Test
    public void testDoubleDigits(){
        NumberToWord numberToWord = new NumberToWord();
        Map<Integer, String> numMap = new HashMap<Integer, String>();
        numMap.put(10, "ten");
        numMap.put(11, "eleven");
        numMap.put(12, "twelve");
        numMap.put(13, "thirteen");
        numMap.put(14, "fourteen");
        numMap.put(15, "fifteen");
        numMap.put(16, "sixteen");
        numMap.put(17, "seventeen");
        numMap.put(18, "eighteen");
        numMap.put(19, "nineteen");
        numMap.put(20, "twenty");
        numMap.put(21, "twenty one");
        numMap.put(22, "twenty two");
        numMap.put(23, "twenty three");
        numMap.put(24, "twenty four");
        numMap.put(25, "twenty five");
        numMap.put(26, "twenty six");
        numMap.put(27, "twenty seven");
        numMap.put(28, "twenty eight");
        numMap.put(29, "twenty nine");
        // put some more tens
        numMap.put(39, "thirty nine");
        numMap.put(49, "forty nine");
        numMap.put(59, "fifty nine");
        numMap.put(69, "sixty nine");
        numMap.put(79, "seventy nine");
        numMap.put(89, "eighty nine");
        numMap.put(99, "ninety nine");
        numMap.forEach((key,val) -> assertTrue(numberToWord.toWord(key).equals(val)));
    }

}