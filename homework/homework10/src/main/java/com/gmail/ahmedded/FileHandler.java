package com.gmail.ahmedded;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    private final static String BASE_PATH = "/Users/ahmedik/Documents/JavaProject/JavaProDaniil/BazaMaven/src/main/java/com/gmail/ahmedded/homework/homework10/";

    public String writeFile(String fileName, String fileContent) {
        try (FileWriter fw = new FileWriter(BASE_PATH + fileName + ".txt")) {
            fw.write(fileContent);
            return "Success.";
        } catch (Exception e) {
            return "Чот не так: " + e.getMessage();
        }
    }

    public String readFile(String path) {
        try (FileReader reader = new FileReader(path)) {
            int sym;
            StringBuilder sb = new StringBuilder();
            while ((sym = reader.read()) != -1) {
                sb.append((char) sym);
            }
            return sb.toString();
        } catch (IOException ex) {
            return ex.getMessage();
        }
    }
}
