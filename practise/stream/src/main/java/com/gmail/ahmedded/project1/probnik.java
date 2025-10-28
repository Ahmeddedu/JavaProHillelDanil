package com.gmail.ahmedded.project1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class probnik {
    public static void main(String[] args){
        List<String> name = Arrays.asList(
                "Даня", "Иван", "Олег", "Анна", "Алексей", "ольга", "Оля", "Anna","Оля"
        );

        Stream<String> stream1 = name.stream().distinct().sorted().filter(s -> s.matches(".*[^a-zA-Z].*")).filter(n -> Character.isUpperCase(n.charAt(0)));
        List<String> result = stream1.collect(Collectors.toList());
        System.out.println(result);
    }
}
