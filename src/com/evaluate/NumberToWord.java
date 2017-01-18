package com.evaluate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vishalsharma on 18/01/2017.
 */
public class NumberToWord {
    private Map<Integer, String> digitsMap;
    private Map<Integer, String> tensMap;

    public NumberToWord(){
        // initialisation of digitsMap containing numbers less than 20
        digitsMap = new HashMap<>();
        digitsMap.put(1, "one");
        digitsMap.put(2, "two");
        digitsMap.put(3, "three");
        digitsMap.put(4, "four");
        digitsMap.put(5, "five");
        digitsMap.put(6, "six");
        digitsMap.put(7, "seven");
        digitsMap.put(8, "eight");
        digitsMap.put(9, "nine");
        digitsMap.put(10, "ten");
        digitsMap.put(11, "eleven");
        digitsMap.put(12, "twelve");
        digitsMap.put(13, "thirteen");
        digitsMap.put(14, "fourteen");
        digitsMap.put(15, "fifteen");
        digitsMap.put(16, "sixteen");
        digitsMap.put(17, "seventeen");
        digitsMap.put(18, "eighteen");
        digitsMap.put(19, "nineteen");

        // initialisation of tens when number is greater than or equal to 20
        tensMap = new HashMap<>();
        tensMap.put(2, "twenty");
        tensMap.put(3, "thirty");
        tensMap.put(4, "forty");
        tensMap.put(5, "fifty");
        tensMap.put(6, "sixty");
        tensMap.put(7, "seventy");
        tensMap.put(8, "eighty");
        tensMap.put(9, "ninety");

    }

    private String handleThreeDigits(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        int firstDigit = number/100;
        stringBuilder
                .append(digitsMap.get(firstDigit))
                .append(" ")
                .append("hundred");
        if (number % 100 == 0) {
            return stringBuilder.toString();
        } else {
            stringBuilder.append(" and ");
            int lastTwoDigits = number % 100;
            stringBuilder.append(handleTwoDigits(lastTwoDigits));
            return stringBuilder.toString();
        }
    }

    private String handleTwoDigits(int number){
        if (number < 20) {
            return digitsMap.get(number);
        } else {
            int firstDigit, secondDigit;
            secondDigit = number % 10;
            firstDigit = number / 10;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(tensMap.get(firstDigit));
            if (digitsMap.get(secondDigit)!=null){
                stringBuilder.append(" ")
                        .append(digitsMap.get(secondDigit));
            }
            return stringBuilder.toString();
        }
    }

    public String toWord(int number){
        if (number >= 100){
            return handleThreeDigits(number);
        } else {
            return handleTwoDigits(number);
        }
    }
}
