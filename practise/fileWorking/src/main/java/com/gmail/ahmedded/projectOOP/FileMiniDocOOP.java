package com.gmail.ahmedded.projectOOP;

import java.io.IOException;
import java.util.Scanner;

public class FileMiniDocOOP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Сбор данных
        System.out.println("What is your name:");
        String name = scanner.nextLine();

        System.out.println("What is your nickname:");
        String nickname = scanner.nextLine();

        System.out.println("What is your favorite programming language:");
        String programmingLanguage = scanner.nextLine();

        UserInfo user = new UserInfo(name, nickname, programmingLanguage);
        FileManager fileManager = new FileManager("MyDoc.txt");

        try {
            boolean isNew = fileManager.createFile();
            if (!isNew) {
                System.out.println("Do you want to delete it? 1 - Yes, 2 - No");
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1) {
                    if (!fileManager.deleteFile()) return;
                    fileManager.createFile();
                } else {
                    System.out.println("File kept as is");
                }
            }

            // Запись основных данных
            fileManager.writeToFile(user.toString(), true);

            // Добавление текста
            System.out.println("Do you want to add extra text? 1 - Yes, 2 - No");
            int addChoice = scanner.nextInt();
            scanner.nextLine();
            if (addChoice == 1) {
                System.out.println("Type all you want:");
                String extra = scanner.nextLine();
                fileManager.writeToFile(extra + "\n", true);
            }

            // Чтение файла
            fileManager.readFile();

        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
