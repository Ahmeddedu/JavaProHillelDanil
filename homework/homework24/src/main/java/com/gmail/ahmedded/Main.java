package com.gmail.ahmedded;

public class Main {
    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        logger1.log("Начало прогр");

        Logger logger2 = Logger.getInstance();
        logger2.log("Продолжени");

        System.out.println("Одинаковые лог -  " + (logger1 == logger2));
    }
}

