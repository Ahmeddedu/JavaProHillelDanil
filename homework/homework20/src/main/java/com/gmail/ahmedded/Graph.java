package com.gmail.ahmedded.homework.homework20;

import java.util.*;

public class Graph {
    //тут крч ключ вершина а значение спсиок смежных вершн
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new ArrayList<>());
            System.out.println("Вершину " + vertex + " дод");
        } else {
            System.out.println("Вершина " + vertex + " есть");
        }
    }

    public void addEdge(int source, int destination) {
        if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(destination)) {
            System.out.println("ошибка 2 врешины должэно быть");
            return;
        }

        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // для неорієнтованого графа
        System.out.println("ребро между " + source + " и " + destination + " добавлено");
    }

    public void removeVertex(int vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            System.out.println("Верншины " + vertex + " нема");
            return;
        }

        adjacencyList.values().forEach(e -> e.remove(Integer.valueOf(vertex)));
        adjacencyList.remove(vertex);
        System.out.println("Вершину" + vertex + " удалено");
    }

    public void removeEdge(int source, int destination) {
        if (adjacencyList.containsKey(source)) {
            adjacencyList.get(source).remove(Integer.valueOf(destination));
        }
        if (adjacencyList.containsKey(destination)) {
            adjacencyList.get(destination).remove(Integer.valueOf(source));
        }
        System.out.println("Ребро между " + source + " и " + destination + " удалено");
    }

    public boolean hasVertex(int vertex) {
        return adjacencyList.containsKey(vertex);
    }

    public boolean hasEdge(int source, int destination) {
        return adjacencyList.containsKey(source)
                && adjacencyList.get(source).contains(destination);
    }

    public void printGraph() {
        System.out.println("\nГраф сецчас:");
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
