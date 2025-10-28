package com.gmail.ahmedded;

import java.util.Random;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //made random array
        int size = 10;
        int[] numbers = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(100);
        }

        System.out.println("Basik array: " + Arrays.toString(numbers));

        ArrayUtils.mergeSort(numbers);
        System.out.println("Sort array: " + Arrays.toString(numbers));

        int target = numbers[random.nextInt(size)];
        int index = ArrayUtils.binarySearch(numbers, target);
        System.out.println("Found number " + target + " on : " + index);
    }
}

