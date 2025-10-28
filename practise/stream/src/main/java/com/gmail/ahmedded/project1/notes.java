package com.gmail.ahmedded.project1;

import java.util.*;
import java.util.stream.*;

public class notes {
    public static void main(String[] args) {

        // Исходные данные — список имён
        List<String> names = Arrays.asList(
                "Даня", "Иван", "Олег", "Анна", "Алексей", "Ольга", "Оля", "Оля"
        );

        // 1) Создаём стрим из списка
        Stream<String> stream1 = names.stream(); // Источник данных (List → Stream)
        System.out.println("\nStream создан: " + stream1);

        // 2) Фильтрация: оставляем имена длиннее 4 букв
        Stream<String> stream2 = stream1.filter(name -> name.length() > 4);
        System.out.println("\nStream после filter: " + stream2);

        // 3) Преобразование: переводим в верхний регистр
        Stream<String> stream3 = stream2.map(String::toUpperCase);
        System.out.println("\nStream после map: " + stream3);

        // 4) Убираем дубликаты
        Stream<String> stream4 = stream3.distinct();
        System.out.println("\nStream после distinct: " + stream4);

        // 5) Сортировка по алфавиту и по цифрам
        Stream<String> stream5 = stream4.sorted();
        System.out.println("\nStream после sorted: " + stream5);

        // 6) Подсмотрим данные (для отладки)
        Stream<String> stream6 = stream5.peek(n -> System.out.println("Элемент после сортировки: " + n));
        System.out.println("\nStream после peek: " + stream6);

        // 7) Берём только первые 3
        Stream<String> stream7 = stream6.limit(3);
        System.out.println("\nStream после limit: " + stream7);

        // 8) Терминальная операция: собираем в список
        List<String> result = stream7.collect(Collectors.toList());
        System.out.println("\nИтоговый список: " + result);

        // -----------------------------
        // ТЕРМИНАЛЬНЫЕ ОПЕРАЦИИ STREAM (полный конспект)
        // -----------------------------

        // 1) Подсчёт элементов (без дубликатов)
        long count = names.stream().distinct().count();
        // count() — количество элементов в потоке после промежуточных операций
        System.out.println("Количество уникальных имён: " + count);

        // 2) Проверка условий
        boolean hasAnna = names.stream().anyMatch(n -> n.equals("Анна"));
        // anyMatch() — true, если хотя бы один элемент удовлетворяет условию
        System.out.println("Есть ли 'Анна'? " + hasAnna);

        boolean allLong = names.stream().allMatch(n -> n.length() > 2);
        // allMatch() — true, если все элементы удовлетворяют условию
        System.out.println("Все имена длиннее 2 букв? " + allLong);

        boolean noneEmpty = names.stream().noneMatch(String::isEmpty);
        // noneMatch() — true, если ни один элемент не удовлетворяет условию
        System.out.println("Нет пустых имён? " + noneEmpty);

        // 3) Свёртка (reduce)
        String joined = names.stream()
                .reduce((a, b) -> a + ", " + b)
                .orElse("Нет имён");
        // reduce() — объединяет все элементы потока в одно значение
        System.out.println("Все имена одной строкой: " + joined);

        // 4) Группировка по ключу
        Map<Integer, List<String>> grouped = names.stream()
                .collect(Collectors.groupingBy(String::length));
        // groupingBy() — Map<ключ, список элементов>, ключ = результат функции
        System.out.println("Группировка по длине: " + grouped);

        // 5) Разделение на группы по условию
        Map<Boolean, List<String>> partitioned = names.stream()
                .collect(Collectors.partitioningBy(n -> n.length() > 4));
        // partitioningBy() — Map<Boolean, List<Элементы>>, true = условие выполнено, false = нет
        System.out.println("Имена >4 букв / ≤4 букв: " + partitioned);

        // 6) Найти первый элемент, соответствующий условию
        Optional<String> first = names.stream()
                .filter(n -> n.length() > 4)
                .findFirst();
        // findFirst() — возвращает Optional с первым элементом, соответствующим условию
        System.out.println("Первое имя длиннее 4 букв: " + first.orElse("Нет"));

        // 7) Найти любой элемент, соответствующий условию
        Optional<String> any = names.stream()
                .filter(n -> n.length() > 4)
                .findAny();
        // findAny() — возвращает Optional с любым элементом потока, соответствующим условию
        System.out.println("Любое имя длиннее 4 букв: " + any.orElse("Нет"));

        // 8) Минимальный элемент по компаратору
        Optional<String> minName = names.stream().min(Comparator.comparingInt(String::length));
        // min() — возвращает Optional с минимальным элементом по компаратору
        System.out.println("Короткое имя: " + minName.orElse("Нет"));

        // 9) Максимальный элемент по компаратору
        Optional<String> maxName = names.stream().max(Comparator.comparingInt(String::length));
        // max() — возвращает Optional с максимальным элементом по компаратору
        System.out.println("Длинное имя: " + maxName.orElse("Нет"));

        // 10) Соединение элементов в строку с разделителем
        String joinedWithSep = names.stream().collect(Collectors.joining(" | "));
        // joining() — объединяет элементы потока в строку с указанным разделителем
        System.out.println("Имена через '|': " + joinedWithSep);

        // 11) Плоское отображение вложенных потоков
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Даня","Иван"),
                Arrays.asList("Олег","Анна")
        );

        List<String> flat = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        // flatMap() — разворачивает вложенные потоки в один поток
        System.out.println("Все имена из вложенных списков: " + flat);

        // 12) Вывод элементов на консоль
        names.stream().forEach(System.out::println);
        // forEach() — выполняет действие для каждого элемента потока
    }
}
