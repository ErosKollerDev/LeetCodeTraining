package com.practicing02;

import java.util.HashMap;
import java.util.Map;

public class Leet_008_RomanToInteger_eros {

    public static void main(String[] args) {
        Leet_008_RomanToInteger_eros leet = new Leet_008_RomanToInteger_eros();

        System.out.println(leet.romanToInt("XXVII")); //27

        System.out.println(leet.romanToInt("LVIII")); //58

        System.out.println(leet.romanToInt("MCMXCIV")); //1994

        System.out.println(leet.romanToInt("IV")); //4
    }

    public int romanToInt(String romanToConvert) {
        if (romanToConvert.isEmpty()) return 0;
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
            int romanValue = map.get(romanToConvert.charAt(i));
            if ((i + 1) < romanToConvert.length() && map.get(romanToConvert.charAt(i + 1)) > romanValue) {
                result = result - romanValue;
            } else {
                result = result + romanValue;
            }
        }

        return result;
    }

}
