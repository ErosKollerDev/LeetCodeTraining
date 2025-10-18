package com.leetcode;

public class Leet_007_RomanToInteger {

    public static void main(String[] args) {
        Leet_007_RomanToInteger leet = new Leet_007_RomanToInteger();

        System.out.println(leet.romanToInt("XXVII")); //27

        System.out.println(leet.romanToInt("LVIII")); //58

        System.out.println(leet.romanToInt("MCMXCIV")); //1994

        System.out.println(leet.romanToInt("IV")); //4
    }

    public int romanToInt(String s) {
        if (s.isEmpty()) return 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            int charValue = romanToInt(c);
            if (i + 1 < s.length() && charValue < romanToInt(s.charAt(i + 1))) {
                result = result - charValue;
            } else {
                result = result + charValue;
            }


        }
        return result;
    }

    static int romanToInt(char s) {
        int result = 0;
        switch (s) {
            case 'I':
                result = 1;
                break;
            case 'V':
                result = 5;
                break;
            case 'X':
                result = 10;
                break;
            case 'L':
                result = 50;
                break;
            case 'C':
                result = 100;
                break;
            case 'D':
                result = 500;
                break;
            case 'M':
                result = 1000;
        }
        return result;
    }
}
