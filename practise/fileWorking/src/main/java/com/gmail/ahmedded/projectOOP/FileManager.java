package com.gmail.ahmedded.projectOOP;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {
    private static final String BASE_PATH = "/Users/ahmedik/Documents/JavaProject/JavaProDaniil/BazaMaven/src/main/java/com/gmail/ahmedded/practise/fileWorking/fileMiniDocOOPIK/";
    private File file;

    public FileManager(String fileName) {
        file = new File(BASE_PATH + fileName);
    }

    public boolean createFile() throws IOException {
        if (file.createNewFile()) {
            System.out.println("Your file was made");
            return true;
        } else {
            System.out.println("File already exists");
            return false;
        }
    }

    public boolean deleteFile() {
        System.out.println("Пытаемся удалить файл: " + file.getAbsolutePath());

        if (!file.exists()) {
            System.out.println("Файл не найден, удалять нечего.");
            return true;  // Файл уже отсутствует — значит удаление успешно
        }

        boolean deleted = file.delete();

        if (deleted) {
            System.out.println("File deleted");
        } else {
            System.out.println("Failed to delete file");
        }
        System.exit(0);
        return deleted;

    }

    public void writeToFile(String text, boolean append) throws IOException {
        try (FileWriter writer = new FileWriter(file, append)) {
            writer.write(text);
        }
    }

    public void readFile() throws IOException {
        try (Scanner fileScanner = new Scanner(file)) {
            System.out.println("\nWhat in file:");
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        }
    }
}
