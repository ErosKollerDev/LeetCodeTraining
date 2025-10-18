package com.practicing02;

public class Leet_009_IntegerToRoman_eros {

    public static void main(String[] args) {
        Leet_009_IntegerToRoman_eros leet = new Leet_009_IntegerToRoman_eros();

//        System.out.println(leet.intToRoman(10)); //X
        System.out.println(leet.intToRoman(1543)); //X
//        System.out.println(leet.intToRoman(2000)); //MM
//        System.out.println(leet.intToRoman(1994)); //MCMXCIV
//        System.out.println(leet.intToRoman(35137)); //MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMCXXXVII
//        System.out.println(leet.intToRoman(2000)); //MM


    }


    public String intToRoman(int numToConvert) {
        String[] romansNumber = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] intRomans = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < intRomans.length; i ++){
            int roman = intRomans[i];

            while(roman <= numToConvert){
                numToConvert = numToConvert - roman;
                sb.append(romansNumber[i]);
            }
        }
        return sb.toString();
    }

}
