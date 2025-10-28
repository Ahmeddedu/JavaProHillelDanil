package com.gmail.ahmedded;

public class Convertor {

    public static double farengateToCelsium(double farengate){
        double result = (farengate - 32) * 5 / 9;
        return result;
    }

    public static double celsiumToFarengate(double celsium){
        double result = celsium * 9 / 5 + 32;
        return result;
    }

    public static void main(String[] args){
        double farenYet = 100;
        double celsiumYet = 100;

        System.out.println(celsiumYet + " C = " + celsiumToFarengate(celsiumYet) + " F");
        System.out.println(farenYet + " F = " + farengateToCelsium(farenYet) + " C");
    }
}