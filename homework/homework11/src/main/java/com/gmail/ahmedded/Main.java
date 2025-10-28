package com.gmail.ahmedded;

import java.nio.file.Paths;

public class Main {

    private static final String BASE_PATH = "/Users/ahmedik/Documents/JavaProject/JavaProDaniil/BazaMaven/src/main/java/com/gmail/ahmedded/homework/homework11/";

    public static void main(String[] args) {
        FileHandler handler = new FileHandler();
        String newFileName = "myfile";
        String content = "Super information.";
        String path = BASE_PATH + newFileName + ".txt";

        getOutput(handler.createFile(path));
        getOutput(handler.writeToFile(Paths.get(path), content));
        getOutput("CONTENT: " + handler.readFromFile(path));
    }

    private static void getOutput(String output) {
        System.out.println(output);
    }
}
