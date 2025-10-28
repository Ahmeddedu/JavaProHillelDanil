package com.gmail.ahmedded;

// 📁 FileBasics.java — ВСЕ ОСНОВНЫЕ ОПЕРАЦИИ С ФАЙЛАМИ (java.io + Scanner)

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BazeMethodsWorkingWithFile {
    public static void main(String[] args) {
        try {
            // 🔹 1. СОЗДАНИЕ ФАЙЛА
            File file = new File("example.txt");
            if (file.createNewFile()) {
                System.out.println("Файл создан: " + file.getName());
            } else {
                System.out.println("Файл уже существует.");
            }

            // 🔹 2. ЗАПИСЬ В ФАЙЛ (перезапись)
            FileWriter writer = new FileWriter(file); // перезаписывает файл
            writer.write("Привет, Даня!\n");
            writer.write("Это запись в файл с нуля.");
            writer.close();
            System.out.println("Файл успешно записан (перезапись).");

            // 🔹 3. ДОЗАПИСЬ В ФАЙЛ
            FileWriter appendWriter = new FileWriter(file, true); // true = append
            appendWriter.write("Добавленная строка с помощью append\n");
            appendWriter.close();
            System.out.println("➕ Строка успешно добавлена в файл.");

            // 🔹 4. ЧТЕНИЕ ФАЙЛА ПОСТРОЧНО С ПОМОЩЬЮ SCANNER
            Scanner scanner = new Scanner(file);
            System.out.println("\n Содержимое файла:");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();

            // 🔹 5. ЧТЕНИЕ ФАЙЛА ПО СЛОВАМ С ПОМОЩЬЮ SCANNER
            Scanner wordScanner = new Scanner(file);
            System.out.println("\n Слова из файла:");
            while (wordScanner.hasNext()) {
                String word = wordScanner.next();
                System.out.println(word);
            }
            wordScanner.close();

            // 🔹 6. ПРОВЕРКИ ФАЙЛА
            System.out.println("\n Проверки файла:");
            System.out.println("Существует: " + file.exists());
            System.out.println("Это файл: " + file.isFile());
            System.out.println("Путь: " + file.getPath());
            System.out.println("Абсолютный путь: " + file.getAbsolutePath());
            System.out.println("Размер (байт): " + file.length());

            // 🔹 7. УДАЛЕНИЕ ФАЙЛА (необязательно)
            // if (file.delete()) {
            //     System.out.println("🗑 Файл удалён.");
            // } else {
            //     System.out.println("Не удалось удалить файл.");
            // }

        } catch (IOException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

