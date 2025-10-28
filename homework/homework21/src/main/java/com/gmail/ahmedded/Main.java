package com.gmail.ahmedded;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {2, 5, 8, 1, 9};

        System.out.println("Макс -  " + ArrayUtils.findMax(numbers));
        System.out.println("Сред - " + ArrayUtils.calculateAverage(numbers));
        System.out.println();

        Class<ArrayUtils> clazz = ArrayUtils.class;
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(MethodInfo.class) && method.isAnnotationPresent(Author.class)) {
                MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                Author author = method.getAnnotation(Author.class);

                System.out.println("Метод - " + methodInfo.name());
                System.out.println("Тип возрата -  " + methodInfo.returnType());
                System.out.println("Описание -  " + methodInfo.description());
                System.out.println("Автор -  " + author.firstName() + " " + author.lastName());
                System.out.println("--------------------------------");
            }
        }
    }
}

