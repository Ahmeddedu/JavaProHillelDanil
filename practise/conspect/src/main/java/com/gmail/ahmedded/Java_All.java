package com.gmail.ahmedded;

import java.io.*;
import java.util.*;
import java.time.*;
import java.util.concurrent.*;

public class Java_All {

    public static void main(String[] args) throws Exception {

        System.out.println("===== JAVA CHEAT SHEET — ВСЕ ОСНОВЫ =====");

        /* ------------------------------------------------------
         * 1. ПЕРЕМЕННЫЕ И ТИПЫ ДАННЫХ
         * ------------------------------------------------------ */
        int number = 10;
        double price = 99.99;
        boolean isJavaFun = true;
        char letter = 'A';
        String text = "Hello Java!";
        final double PI = 3.14159; // Константа
        System.out.printf("Переменные: %d, %.2f, %b, %c, %s%n", number, price, isJavaFun, letter, text);

        /* ------------------------------------------------------
         * 2. ОПЕРАТОРЫ
         * ------------------------------------------------------ */
        int a = 5, b = 3;
        System.out.println("Сложение: " + (a + b));
        System.out.println("Разность: " + (a - b));
        System.out.println("Умножение: " + (a * b));
        System.out.println("Деление: " + ((double) a / b));
        System.out.println("Остаток: " + (a % b));
        System.out.println("Сравнение: " + (a > b));
        System.out.println("Логика: " + (a > 0 && b > 0));

        /* ------------------------------------------------------
         * 3. УСЛОВНЫЕ ОПЕРАТОРЫ
         * ------------------------------------------------------ */
        if (a > b) {
            System.out.println("a больше b");
        } else if (a == b) {
            System.out.println("a равно b");
        } else {
            System.out.println("a меньше b");
        }
        // Тернарный оператор
        String result = (a > b) ? "Да" : "Нет";
        System.out.println("a > b? " + result);

        /* ------------------------------------------------------
         * 4. ЦИКЛЫ
         * ------------------------------------------------------ */
        for (int i = 0; i < 3; i++) {
            System.out.println("for: " + i);
        }
        int i = 0;
        while (i < 3) {
            System.out.println("while: " + i);
            i++;
        }
        i = 0;
        do {
            System.out.println("do-while: " + i);
            i++;
        } while (i < 3);

        /* ------------------------------------------------------
         * 5. МАССИВЫ
         * ------------------------------------------------------ */
        int[] arr = {1, 2, 3};
        System.out.println("Длина массива: " + arr.length);
        System.out.println("Элемент [0]: " + arr[0]);

        /* ------------------------------------------------------
         * 6. СТРОКИ (основные методы)
         * ------------------------------------------------------ */
        String s = "Java Programming";
        System.out.println("Длина: " + s.length());
        System.out.println("Верхний регистр: " + s.toUpperCase());
        System.out.println("Нижний регистр: " + s.toLowerCase());
        System.out.println("Подстрока: " + s.substring(5, 16));
        System.out.println("Замена: " + s.replace("Java", "C++"));
        System.out.println("Содержит 'Pro'? " + s.contains("Pro"));
        System.out.println("Сравнение equals: " + s.equals("Java"));
        System.out.println("Начинается с 'Java'? " + s.startsWith("Java"));
        System.out.println("Заканчивается на 'ing'? " + s.endsWith("ing"));
        System.out.println("Разбиение: " + Arrays.toString(s.split(" ")));

        /* ------------------------------------------------------
         * 7. StringBuilder (все основные методы)
         * ------------------------------------------------------ */
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        sb.insert(5, ",");
        sb.delete(5, 6);
        sb.replace(0, 5, "Hi");
        sb.reverse();
        sb.reverse(); // Вернули обратно
        System.out.println("StringBuilder: " + sb);
        System.out.println("Длина: " + sb.length());
        System.out.println("Вместимость: " + sb.capacity());
        sb.ensureCapacity(50);
        System.out.println("Новая вместимость: " + sb.capacity());

        /* ------------------------------------------------------
         * 8. LIST — ArrayList & LinkedList
         * ------------------------------------------------------ */
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add(1, "Orange");
        arrayList.remove("Banana");
        arrayList.set(0, "Grapes");
        System.out.println("ArrayList: " + arrayList);
        System.out.println("Есть 'Orange'? " + arrayList.contains("Orange"));
        System.out.println("Размер: " + arrayList.size());

        List<String> linkedList = new LinkedList<>(arrayList);
        ((LinkedList<String>) linkedList).addFirst("First");
        ((LinkedList<String>) linkedList).addLast("Last");
        System.out.println("LinkedList: " + linkedList);

        /* ------------------------------------------------------
         * 9. SET — HashSet & TreeSet
         * ------------------------------------------------------ */
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Red");
        hashSet.add("Blue");
        hashSet.add("Red"); // дубликат игнорируется
        hashSet.remove("Blue");
        System.out.println("HashSet: " + hashSet);
        System.out.println("Содержит 'Red'? " + hashSet.contains("Red"));

        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Zebra");
        treeSet.add("Apple");
        System.out.println("TreeSet (сортировка): " + treeSet);

        /* ------------------------------------------------------
         * 10. MAP — HashMap, TreeMap, LinkedHashMap
         * ------------------------------------------------------ */
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("One", 1);
        hashMap.put("Two", 2);
        hashMap.remove("Two");
        System.out.println("HashMap: " + hashMap);
        System.out.println("Ключи: " + hashMap.keySet());
        System.out.println("Значения: " + hashMap.values());
        System.out.println("Записи: " + hashMap.entrySet());

        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("B", 2);
        treeMap.put("A", 1);
        System.out.println("TreeMap: " + treeMap);

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Dog", 5);
        linkedHashMap.put("Cat", 3);
        System.out.println("LinkedHashMap: " + linkedHashMap);

        /* ------------------------------------------------------
         * 11. ИСКЛЮЧЕНИЯ
         * ------------------------------------------------------ */
        try {
            int x = 5 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль!");
        } finally {
            System.out.println("Этот блок выполнится всегда");
        }

        /* ------------------------------------------------------
         * 12. РАБОТА С ФАЙЛАМИ
         * ------------------------------------------------------ */
        File file = new File("test.txt");
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println("Первая строка");
            pw.println("Вторая строка");
        }
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                System.out.println("Из файла: " + sc.nextLine());
            }
        }

        /* ------------------------------------------------------
         * 13. ДАТА И ВРЕМЯ
         * ------------------------------------------------------ */
        LocalDate today = LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        LocalDateTime dt = LocalDateTime.now();
        System.out.println("Сегодня: " + today + ", Время: " + timeNow + ", ДатаВремя: " + dt);

        /* ------------------------------------------------------
         * 14. МНОГОПОТОЧНОСТЬ
         * ------------------------------------------------------ */
        Runnable task = () -> {
            System.out.println("Поток: " + Thread.currentThread().getName());
        };
        Thread t1 = new Thread(task);
        t1.start();
        t1.join();
        System.out.println("Ждём 1 секунду...");
        Thread.sleep(1000);
        System.out.println("Прошла 1 секунда");

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> System.out.println("Задача 1"));
        executor.submit(() -> System.out.println("Задача 2"));
        executor.shutdown();

        /* ------------------------------------------------------
         * 15. ЛЯМБДА
         * ------------------------------------------------------ */
        arrayList.forEach(item -> System.out.println("Элемент: " + item));

        System.out.println("===== КОНЕЦ Java_All =====");
    }
}
