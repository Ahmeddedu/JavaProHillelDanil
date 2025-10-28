package com.gmail.ahmedded.project1;

import java.util.HashMap;
import java.util.Map;

public class Garagik {
    public static void main(String[] args) throws InterruptedException {
        Map<String, Integer> cars = new HashMap<>();

        cars.put("Audi", 1);
        cars.put("Bmw", 2);
        cars.put("Lexus", 3);
        cars.put("RangeRover", 4);

        System.out.println(cars);

        Thread.sleep(1000);

        for (Map.Entry<String, Integer> entry : cars.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("{Key - (" + key + "), Value - (" + value + ")}");


        }

    }
}
