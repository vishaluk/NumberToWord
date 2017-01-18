package com.evaluate;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by vishalsharma on 18/01/2017.
 */
public class NumberToWord {
    public static final String CONVERSION_NOT_SUPPORTED = "conversion not supported";
    public static final int UPPER_LIMIT = 1000000000;
    public static final int LOWER_LIMIT = 0;
    private Map<Integer, String> digitsMap;
    private Map<Integer, String> tensMap;
    private Map<Integer, String> bigNumberMap;

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

        bigNumberMap = new HashMap<>();
        bigNumberMap.put(1, "thousand");
        bigNumberMap.put(2, "million");

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
            return digitsMap.get(number)!=null?digitsMap.get(number):"";
        } else {
            int firstDigit, secondDigit;
            secondDigit = number % 10;
            firstDigit = number / 10;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(tensMap.get(firstDigit));
            if (digitsMap.get(secondDigit)!=null){
                stringBuilder.append("-")
                        .append(digitsMap.get(secondDigit));
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        Integer numberInput = Integer.parseInt(args[0]);
        NumberToWord numberToWord = new NumberToWord();
        System.out.println(numberToWord.toWord(numberInput));
    }



    public String toWord(int number){
        if (number > LOWER_LIMIT && number < UPPER_LIMIT) {
            //convert number into String separated by commas
            //the idea is to format the number into comma delimited strings, each of max 3 digits
            String numberFormatted = NumberFormat.getNumberInstance(Locale.UK).format(number);
            StringBuilder stringBuilder = new StringBuilder();
            String[] numberParts = numberFormatted.split(",");
            int countOfParts = numberParts.length;
            boolean bigNumberPresent = countOfParts > 1;
            countOfParts--;
            for (String str : numberParts) {
                buildWord(stringBuilder, countOfParts, str, bigNumberPresent);
                countOfParts--;
            }
            return stringBuilder.toString().trim();
        } else {
            return CONVERSION_NOT_SUPPORTED;
        }

    }

    private void buildWord(StringBuilder stringBuilder, int countOfParts, String str, boolean bigNumberPresent) {
        int numberStr = Integer.parseInt(str);
        if (numberStr >= 100) {
            stringBuilder.append(handleThreeDigits(numberStr));
        } else {
            String partialWord = handleTwoDigits(numberStr);
            // in case of terminating counter when thousands and millions are present
            // we need to append and
            if (partialWord.length()>0 && bigNumberPresent && countOfParts==0) stringBuilder.append("and ");
            stringBuilder.append(partialWord);

        }
        if (numberStr > 0 && bigNumberMap.get(countOfParts)!=null) {
            stringBuilder.append(" ")
                    .append(bigNumberMap.get(countOfParts))
                    .append(" ");
        }
    }
}
