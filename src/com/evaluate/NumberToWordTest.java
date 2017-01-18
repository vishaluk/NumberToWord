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
        numMap.put(21, "twenty-one");
        numMap.put(22, "twenty-two");
        numMap.put(23, "twenty-three");
        numMap.put(24, "twenty-four");
        numMap.put(25, "twenty-five");
        numMap.put(26, "twenty-six");
        numMap.put(27, "twenty-seven");
        numMap.put(28, "twenty-eight");
        numMap.put(29, "twenty-nine");
        // put some more tens
        numMap.put(39, "thirty-nine");
        numMap.put(49, "forty-nine");
        numMap.put(59, "fifty-nine");
        numMap.put(69, "sixty-nine");
        numMap.put(79, "seventy-nine");
        numMap.put(89, "eighty-nine");
        numMap.put(99, "ninety-nine");
        numMap.forEach((key,val) -> assertTrue(numberToWord.toWord(key).equals(val)));
    }

    @Test
    public void testThreeDigitsWithTensLessThan20(){
        NumberToWord numberToWord = new NumberToWord();
        Map<Integer, String> numMap = new HashMap<Integer, String>();
        numMap.put(100, "one hundred");
        numMap.put(101, "one hundred and one");
        numMap.put(102, "one hundred and two");
        numMap.put(103, "one hundred and three");
        numMap.put(104, "one hundred and four");
        numMap.put(105, "one hundred and five");
        numMap.put(106, "one hundred and six");
        numMap.put(107, "one hundred and seven");
        numMap.put(108, "one hundred and eight");
        numMap.put(109, "one hundred and nine");
        numMap.put(110, "one hundred and ten");
        numMap.put(111, "one hundred and eleven");
        numMap.put(112, "one hundred and twelve");
        numMap.put(113, "one hundred and thirteen");
        numMap.put(114, "one hundred and fourteen");
        numMap.put(115, "one hundred and fifteen");
        numMap.put(116, "one hundred and sixteen");
        numMap.put(117, "one hundred and seventeen");
        numMap.put(118, "one hundred and eighteen");
        numMap.put(119, "one hundred and nineteen");
        numMap.forEach((key,val) -> assertTrue(numberToWord.toWord(key).equals(val)));
    }

    @Test
    public void testThreeDigitsWithTensGreaterThanEqualTo20(){
        NumberToWord numberToWord = new NumberToWord();
        Map<Integer, String> numMap = new HashMap<Integer, String>();
        numMap.put(120, "one hundred and twenty");
        numMap.put(121, "one hundred and twenty-one");
        numMap.put(122, "one hundred and twenty-two");
        numMap.put(123, "one hundred and twenty-three");
        numMap.put(124, "one hundred and twenty-four");
        numMap.put(125, "one hundred and twenty-five");
        numMap.put(126, "one hundred and twenty-six");
        numMap.put(127, "one hundred and twenty-seven");
        numMap.put(128, "one hundred and twenty-eight");
        numMap.put(129, "one hundred and twenty-nine");
        numMap.put(139, "one hundred and thirty-nine");
        numMap.put(149, "one hundred and forty-nine");
        numMap.put(159, "one hundred and fifty-nine");
        numMap.put(169, "one hundred and sixty-nine");
        numMap.put(179, "one hundred and seventy-nine");
        numMap.put(189, "one hundred and eighty-nine");
        numMap.put(199, "one hundred and ninety-nine");
        numMap.put(229, "two hundred and twenty-nine");
        numMap.put(339, "three hundred and thirty-nine");
        numMap.put(449, "four hundred and forty-nine");
        numMap.put(559, "five hundred and fifty-nine");
        numMap.put(669, "six hundred and sixty-nine");
        numMap.put(779, "seven hundred and seventy-nine");
        numMap.put(889, "eight hundred and eighty-nine");
        numMap.put(999, "nine hundred and ninety-nine");
        numMap.forEach((key,val) -> assertTrue(numberToWord.toWord(key).equals(val)));
    }

    @Test
    public void testNumbersInThousands() {
        NumberToWord numberToWord = new NumberToWord();
        assertTrue(numberToWord.toWord(5145).equals("five thousand one hundred and forty-five"));
        assertTrue(numberToWord.toWord(71000).equals("seventy-one thousand"));
        assertTrue(numberToWord.toWord(999999).equals("nine hundred and ninety-nine thousand nine hundred and ninety-nine"));
    }

    @Test
    public void testNumbersInMillions() {
        NumberToWord numberToWord = new NumberToWord();
        assertTrue(numberToWord.toWord(5145000).equals("five million one hundred and forty-five thousand"));
        assertTrue(numberToWord.toWord(7100000).equals("seven million one hundred thousand"));
        assertTrue(numberToWord.toWord(45001000).equals("forty-five million one thousand"));
        assertTrue(numberToWord.toWord(22100001).equals("twenty-two million one hundred thousand and one"));
        assertTrue(numberToWord.toWord(22100051).equals("twenty-two million one hundred thousand and fifty-one"));
        assertTrue(numberToWord.toWord(999999999).equals("nine hundred and ninety-nine million nine hundred and ninety-nine thousand nine hundred and ninety-nine"));
    }

}