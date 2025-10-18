package com.roadmap;

public class A17_Leet_009_IntegerToRoman {

    public static void main(String[] args) {
        A17_Leet_009_IntegerToRoman leet = new A17_Leet_009_IntegerToRoman();

        System.out.println(leet.intToRoman(10)); //X
        System.out.println(leet.intToRoman(2000)); //MM
        System.out.println(leet.intToRoman(1994)); //MCMXCIV
        System.out.println(leet.intToRoman(35137)); //MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMCXXXVII
        System.out.println(leet.intToRoman(2900)); //MMCM


    }


    public String intToRoman(int numToConvert) {
        int[] intRomans = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romansNumber = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intRomans.length; i++) {
            int roman = intRomans[i];
            while(numToConvert >= roman ){
                numToConvert = numToConvert - roman;
                sb.append(romansNumber[i]);
            }
        }
        return sb.toString();
    }

}
