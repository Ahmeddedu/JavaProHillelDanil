package com.gmail.ahmedded;

import java.io.*;

public class Notes {
    public static void main(String[] args) {
        // Используем try-with-resources — поток закроется автоматически
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(Notes.class.getResourceAsStream("/file.txt")))) {

            if (br == null) {
                System.out.println("⚠️ Файл 'file.txt' не найден в resources!");
                return;
            }

            // -----------------------------
            // 1) read() — чтение одного символа
            // -----------------------------
            int ch = br.read();
            System.out.println("read() — первый символ: " + (char) ch);

            // -----------------------------
            // 2) read(char[]...) — чтение массива символов
            // -----------------------------
            char[] buffer = new char[5];
            int numRead = br.read(buffer, 0, buffer.length);
            System.out.println("read(char[]...) — прочитано символов: " + numRead
                    + ", содержимое: " + new String(buffer, 0, numRead));

            // -----------------------------
            // 3) readLine() — чтение строк
            // -----------------------------
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("readLine() — строка: " + line);
            }

            // -----------------------------
            // 4) ready() — проверка готовности
            // -----------------------------
            if (br.ready()) {
                System.out.println("ready() — данные готовы к чтению");
            } else {
                System.out.println("ready() — поток на конце файла, данных нет");
            }

            System.out.println("close() — поток закрыт автоматически (try-with-resources)");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
