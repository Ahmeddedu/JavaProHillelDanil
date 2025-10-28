package com.gmail.ahmedded.homework.homework20;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        graph.printGraph();

        System.out.println("верш 3  " + graph.hasVertex(3));
        System.out.println("верш 5" + graph.hasVertex(5));

        System.out.println("ребро между 1 -2 " + graph.hasEdge(1, 2));
        System.out.println("ребро между 3-4 " + graph.hasEdge(3, 4));

        graph.removeEdge(1, 2);
        graph.removeVertex(4);

        graph.printGraph();
    }
}

