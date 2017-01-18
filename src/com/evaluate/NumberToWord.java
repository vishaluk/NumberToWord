package com.evaluate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vishalsharma on 18/01/2017.
 */
public class NumberToWord {
    private Map<Integer, String> singleDigitsMap;

    public NumberToWord(){
        // initialisation of single digits
        singleDigitsMap = new HashMap<>();
        singleDigitsMap.put(1, "one");
        singleDigitsMap.put(2, "two");
        singleDigitsMap.put(3, "three");
        singleDigitsMap.put(4, "four");
        singleDigitsMap.put(5, "five");
        singleDigitsMap.put(6, "six");
        singleDigitsMap.put(7, "seven");
        singleDigitsMap.put(8, "eight");
        singleDigitsMap.put(9, "nine");
    }

    public String toWord(int number){
        return singleDigitsMap.get(number);
    }
}
