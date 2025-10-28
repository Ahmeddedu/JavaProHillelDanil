package com.gmail.ahmedded;

public class ArrayUtils {

    @MethodInfo(
            name = "findMax",
            returnType = "int",
            description = "Максимальное значение в масиве"
    )
    @Author(firstName = "Кикотев", lastName = "Кикоть")
    public static int findMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    @MethodInfo(
            name = "calculateAverage",
            returnType = "double",
            description = "Сред значение масива"
    )

    @Author(firstName = "Сергей", lastName = "Сергеевчи")
    public static double calculateAverage(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return (double) sum / array.length;
    }
}

