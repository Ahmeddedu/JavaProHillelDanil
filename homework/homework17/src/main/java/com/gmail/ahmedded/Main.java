package com.gmail.ahmedded;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Coffee Maker", "Appliances", 80.0),
                new Product("Headphones", "Electronics", 150.0),
                new Product("Blender", "Appliances", 50.0),
                new Product("TV", "Electronics", 800.0),
                new Product("Fridge", "Appliances", 600.0),
                new Product("Sofa", "Furniture", 1000.0),
                new Product("Chair", "Furniture", 150.0)
        );

        Map<String, Double> avgPriceByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.averagingDouble(Product::getPrice)
                ));

        System.out.println("Midl price for ctgory: " + avgPriceByCategory);

        Optional<Map.Entry<String, Double>> maxCategory = avgPriceByCategory.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        maxCategory.ifPresent(entry ->
                System.out.println("Category with midl price: " +
                        entry.getKey() + " (" + entry.getValue() + ")")
        );
    }
}

