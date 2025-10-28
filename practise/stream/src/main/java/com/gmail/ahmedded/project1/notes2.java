package com.gmail.ahmedded.project1;

import java.util.*;
import java.util.stream.*;

public class notes2 {
    public static void main(String[] args) {

        // -----------------------------
        // 0) Исходные данные
        // -----------------------------
        // Список имён для всех примеров
        List<String> names = Arrays.asList(
                "Даня", "Иван", "Олег", "Анна", "Алексей", "Ольга", "Оля", "Anna", "Mike", "John"
        );
        System.out.println("Исходный список: " + names);

        // -----------------------------
        // 1) stream()
        // -----------------------------
        // stream() — создаёт поток данных из коллекции (List, Set и др.)
        // Поток — это последовательность элементов, с которыми можно выполнять промежуточные и терминальные операции.
        // Зачем: для функциональной обработки коллекций без циклов.
        Stream<String> s1 = names.stream();
        System.out.println("\n1) stream() — поток создан: " + s1);

        // -----------------------------
        // 2) filter()
        // -----------------------------
        // filter(Predicate) — оставляет только элементы, удовлетворяющие условию (true = оставить, false = убрать)
        // Зачем: отбор элементов по критерию
        List<String> filtered1 = names.stream()
                .filter(n -> n.length() > 4) // имена длиннее 4 букв
                .collect(Collectors.toList());
        System.out.println("\n2) filter() — имена длиннее 4: " + filtered1);

        List<String> filtered2 = names.stream()
                .filter(n -> n.startsWith("А")) // имена на букву А
                .collect(Collectors.toList());
        System.out.println("filter() — имена на 'А': " + filtered2);

        List<String> filtered3 = names.stream()
                .filter(n -> n.matches("[А-Яа-я]+")) // только русские
                .collect(Collectors.toList());
        System.out.println("filter() — только русские: " + filtered3);

        List<String> filtered4 = names.stream()
                .filter(n -> n.matches("[A-Za-z]+")) // только английские
                .collect(Collectors.toList());
        System.out.println("filter() — только английские: " + filtered4);

        // -----------------------------
        // 3) map()
        // -----------------------------
        // map(Function) — преобразует каждый элемент в новый
        // Зачем: изменение значений потока (регистр, длина, добавление текста и др.)
        List<String> mapped1 = names.stream()
                .map(String::toUpperCase) // в верхний регистр
                .collect(Collectors.toList());
        System.out.println("\n3) map() — верхний регистр: " + mapped1);

        List<Integer> mapped2 = names.stream()
                .map(String::length) // длина имени
                .collect(Collectors.toList());
        System.out.println("map() — длины имён: " + mapped2);

        List<String> mapped3 = names.stream()
                .map(n -> "Имя: " + n) // добавляем префикс
                .collect(Collectors.toList());
        System.out.println("map() — с префиксом: " + mapped3);

        // -----------------------------
        // 4) distinct()
        // -----------------------------
        // distinct() — убирает дубликаты (сравнение через equals())
        // Зачем: оставляем только уникальные элементы
        List<String> distincted = names.stream()
                .map(String::toLowerCase)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("\n4) distinct() — уникальные имена: " + distincted);

        // -----------------------------
        // 5) sorted()
        // -----------------------------
        // sorted() — сортирует элементы по естественному порядку (алфавит, числа)
        // sorted(Comparator) — сортировка по заданному правилу
        List<String> sorted1 = names.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("\n5) sorted() — алфавит: " + sorted1);

        List<String> sorted2 = names.stream()
                .sorted(Comparator.reverseOrder()) // обратный порядок
                .collect(Collectors.toList());
        System.out.println("sorted() — обратный порядок: " + sorted2);

        List<String> sorted3 = names.stream()
                .sorted(Comparator.comparingInt(String::length)) // по длине
                .collect(Collectors.toList());
        System.out.println("sorted() — по длине: " + sorted3);

        // -----------------------------
        // 6) peek()
        // -----------------------------
        // peek(Consumer) — "подсмотреть" значения на этапе обработки
        // Зачем: для отладки или побочных эффектов без изменения потока
        List<String> peeked = names.stream()
                .map(String::toUpperCase)
                .peek(n -> System.out.println("peek() — элемент: " + n))
                .collect(Collectors.toList());
        System.out.println("\n6) peek() — итоговый список: " + peeked);

        // -----------------------------
        // 7) limit()
        // -----------------------------
        // limit(n) — оставляет только первые n элементов
        // Зачем: ограничение размера потока
        List<String> limited = names.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("\n7) limit() — первые 3: " + limited);

        // -----------------------------
        // 8) skip()
        // -----------------------------
        // skip(n) — пропускает первые n элементов
        // Зачем: пропускаем ненужные элементы, берём оставшиеся
        List<String> skipped = names.stream()
                .skip(5)
                .collect(Collectors.toList());
        System.out.println("\n8) skip() — пропустили 5: " + skipped);

        // -----------------------------
        // 9) Работа с Character
        // -----------------------------
        // Преобразуем строки в отдельные символы и фильтруем по типу
        // Зачем: удобно для работы с буквами и регистром
        List<Character> upperChars = names.stream()
                .flatMap(name -> name.chars().mapToObj(c -> (char) c))
                .filter(Character::isUpperCase)
                .collect(Collectors.toList());
        System.out.println("\n9) Character — только заглавные буквы: " + upperChars);

        List<Character> lowerFirstLetters = names.stream()
                .map(name -> name.charAt(0))
                .filter(Character::isLowerCase)
                .collect(Collectors.toList());
        System.out.println("Character — первые буквы, которые строчные: " + lowerFirstLetters);

        List<Character> onlyLetters = names.stream()
                .flatMap(name -> name.chars().mapToObj(c -> (char) c))
                .filter(Character::isLetter)
                .collect(Collectors.toList());
        System.out.println("Character — только буквы: " + onlyLetters);

        // -----------------------------
        // 10) reduce()
        // -----------------------------
        // reduce() — свёртка всех элементов в одно значение
        // Зачем: объединение, суммирование, конкатенация
        String joinedNames = names.stream()
                .reduce((a,b) -> a + ", " + b)
                .orElse("Нет имён");
        System.out.println("\n10) reduce() — все имена в одной строке: " + joinedNames);

        // -----------------------------
        // 11) count()
        // -----------------------------
        // count() — возвращает количество элементов в потоке
        // Зачем: быстро узнать размер после промежуточных операций
        long count = names.stream().count();
        System.out.println("\n11) count() — количество элементов: " + count);

        // -----------------------------
        // 12) min() / max()
        // -----------------------------
        // min() / max() — найти минимальный/максимальный элемент по компаратору
        // Зачем: найти самую короткую, длинную строку, минимальное число и т.д.
        Optional<String> minName = names.stream().min(Comparator.comparingInt(String::length));
        Optional<String> maxName = names.stream().max(Comparator.comparingInt(String::length));
        System.out.println("\n12) min() — самое короткое имя: " + minName.orElse("Нет"));
        System.out.println("max() — самое длинное имя: " + maxName.orElse("Нет"));

        // -----------------------------
        // 13) anyMatch() / allMatch() / noneMatch()
        // -----------------------------
        // Проверка условий для потока
        // anyMatch() — есть ли хотя бы один элемент, удовлетворяющий условию
        // allMatch() — все элементы удовлетворяют условию
        // noneMatch() — ни один элемент не удовлетворяет условию
        boolean hasAnna = names.stream().anyMatch(n -> n.equals("Анна"));
        boolean allLong = names.stream().allMatch(n -> n.length() > 2);
        boolean noneEmpty = names.stream().noneMatch(String::isEmpty);
        System.out.println("\n13) anyMatch() — есть ли 'Анна'? " + hasAnna);
        System.out.println("allMatch() — все имена длиннее 2 букв? " + allLong);
        System.out.println("noneMatch() — нет пустых имён? " + noneEmpty);

        // -----------------------------
        // 14) findFirst() / findAny()
        // -----------------------------
        // findFirst() — первый элемент, соответствующий условию
        // findAny() — любой элемент (особенно для параллельных стримов)
        Optional<String> firstLong = names.stream()
                .filter(n -> n.length() > 4)
                .findFirst();
        Optional<String> anyLong = names.stream()
                .filter(n -> n.length() > 4)
                .findAny();
        System.out.println("\n14) findFirst() — первое длинное имя: " + firstLong.orElse("Нет"));
        System.out.println("findAny() — любое длинное имя: " + anyLong.orElse("Нет"));

        // -----------------------------
        // 15) flatMap()
        // -----------------------------
        // flatMap() — разворачивает вложенные коллекции в один поток
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Даня","Иван"),
                Arrays.asList("Олег","Анна")
        );
        List<String> flat = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("\n15) flatMap() — все имена из вложенных списков: " + flat);

        // -----------------------------
        // 16) collect()
        // -----------------------------
        // collect() — собирает поток в коллекцию, Map, строку и др.
        Set<String> set = names.stream().collect(Collectors.toSet());
        Map<Integer, String> map = names.stream().collect(Collectors.toMap(
                String::length,
                n -> n,
                (a,b) -> a // если длина повторяется, оставляем первый
        ));
        String joinedWithSep = names.stream().collect(Collectors.joining(" | "));
        System.out.println("\n16) collect() — в Set: " + set);
        System.out.println("collect() — в Map (ключ=длина): " + map);
        System.out.println("collect() — объединение с '|': " + joinedWithSep);

        // -----------------------------
        // 17) takeWhile() / dropWhile() (Java 9+)
        // -----------------------------
        // takeWhile() — берёт элементы до первого false по условию
        // dropWhile() — пропускает элементы до первого false
        List<String> takeWhileExample = names.stream()
                .takeWhile(n -> n.length() <= 4)
                .collect(Collectors.toList());
        List<String> dropWhileExample = names.stream()
                .dropWhile(n -> n.length() <= 4)
                .collect(Collectors.toList());
        System.out.println("\n17) takeWhile() — имена длиной ≤4: " + takeWhileExample);
        System.out.println("dropWhile() — имена длиной >4: " + dropWhileExample);

        // -----------------------------
        // 18) бесконечные потоки
        // -----------------------------
        // Stream.iterate() / Stream.generate() — создаёт бесконечный поток
        // Зачем: генерация чисел, случайных значений, тестовые данные
        System.out.println("\n18) Бесконечный поток — первые 10 чисел:");
        Stream<Integer> infinite = Stream.iterate(1, n -> n + 1);
        infinite.limit(10).forEach(System.out::println);
    }
}
