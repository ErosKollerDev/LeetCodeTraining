package com.roadmap;

import java.util.Map;

public class A16_Leet_007_RomanToInteger {
    public static void main(String[] args) {
        A16_Leet_007_RomanToInteger leet = new A16_Leet_007_RomanToInteger();
        System.out.println(leet.romanToInt("XXVII")); //27
        System.out.println(leet.romanToInt("LVIII")); //58
        System.out.println(leet.romanToInt("MCMXCIV")); //1994
        System.out.println(leet.romanToInt("IV")); //4
        System.out.println(leet.romanToInt("LIX")); //59
    }

    public int romanToInt(String romanToConvert) {
        if (romanToConvert.isEmpty()) return 0;
        Map<Character, Integer> map = Map.of('I', 1,'V', 5,'X', 10,'L', 50,'C', 100,'D', 500,'M', 1000);
        int result = 0;
        int size = romanToConvert.length();
        char[] romanChars = romanToConvert.toCharArray();
        for (int i = 0; i < size; i++) {
            char romanChar = romanChars[i];
            int romanValue = map.get(romanChar);
            if((i+1) < size && romanValue < map.get(romanChars[i+1]) ){
                result -= romanValue;
            }else{
                result += romanValue;
            }
        }

        return result;
    }
}
