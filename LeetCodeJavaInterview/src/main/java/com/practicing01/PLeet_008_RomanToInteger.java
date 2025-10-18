package com.practicing01;

import java.util.HashMap;
import java.util.Map;

public class PLeet_008_RomanToInteger {

    public static void main(String[] args) {
        PLeet_008_RomanToInteger leet = new PLeet_008_RomanToInteger();

        System.out.println(leet.romanToInt("XXVII")); //27

        System.out.println(leet.romanToInt("LVIII")); //58

        System.out.println(leet.romanToInt("MCMXCIV")); //1994

        System.out.println(leet.romanToInt("IV")); //4
    }

    public int romanToInt(String romanToConvert) {
        if (romanToConvert.isEmpty()) return 0;
        int lengthOfRomanNumber = romanToConvert.length();
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;

        for (int i = 0; i < romanToConvert.length(); i++) {

            char romanLetter = romanToConvert.charAt(i);
            int currentChartValue = map.get(romanLetter);
            if ((i + 1) < lengthOfRomanNumber && currentChartValue < map.get(romanToConvert.charAt(i + 1))) {
                //subtract from result
                result = result - currentChartValue;
            } else {
                //add to result
                result = result + currentChartValue;
            }
        }
        return result;
    }

}
