package com.gmail.ahmedded;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        MathOperation addition = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };
        System.out.println("10 + 2: " + addition.operate(10, 25));

        StringManipulator toUpperCase = str -> str.toUpperCase();
        System.out.println("Big word: " + toUpperCase.manipulate("java is cool"));

        Function<String, Integer> uppercaseCounter = StringListProcessor::countUppercase;
        System.out.println("big letter: " + uppercaseCounter.apply("hGhGhYhjH"));

        Supplier<Integer> randomSupplier = () -> RandomNumberGenerator.generateRandomNumber(1, 1000);
        System.out.println("Rand 1 - 1000 : " + randomSupplier.get());
    }
}

