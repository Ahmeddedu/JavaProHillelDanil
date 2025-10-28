package com.gmail.ahmedded.project2.FileSaver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Methodiki {

    private final String BAZA_PATH = "/Users/ahmedik/Documents/JavaProject/JavaProDaniil/BazaMaven/src/main/java/com/gmail/ahmedded/practise/getSetTest/FileSaver/";
    private final Scanner scanner = new Scanner(System.in);

    private String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // очищаем буфер
        return value;
    }

    public BazaDoc collectData() {
        BazaDoc user = new BazaDoc();

        user.setName(readString("Type your Name: "));
        user.setAge(readInt("Type your Age: "));
        user.setNickName(readString("Type your NickName: "));
        user.setCountry(readString("Type your Country: "));
        user.setCity(readString("Type your City: "));
        user.setYear(readInt("Type this Year: "));
        user.setMonth(readInt("Type this Month: "));
        user.setDay(readInt("Type this Day: "));

        return user;
    }

    public int ask(String text) {
        while (true) {
            System.out.println(text);

            if (scanner.hasNextInt()) {
                int result = scanner.nextInt();
                scanner.nextLine(); // очищаем буфер, чтобы не мешал nextLine()
                return result;
            } else {
                System.out.println("Type only number ");
                scanner.next();
            }
        }
    }

    public String nameFile(BazaDoc user){
        System.out.println("Pls type name of file :");
        String FileName = scanner.nextLine();
        user.setNameFile(FileName);
        return FileName;
    }

    public boolean createFile(BazaDoc user) {
        try {
            File fileDoc = new File(BAZA_PATH + user.getNameFile() + ".txt");

            if (fileDoc.exists()) {
                System.out.println("File already exists!");
                return false;
            } else {
                if (fileDoc.createNewFile()) {
                    System.out.println("File was made: " + fileDoc.getName());
                    return true;
                } else {
                    return false;
                }
            }

        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return false;
        }
    }

    public boolean writeInFile(BazaDoc user){
        try{
            System.out.println("Type text to append into file:");
            String result = scanner.nextLine();

            FileWriter appendWriter = new FileWriter(BAZA_PATH + user.getNameFile() + ".txt", true);
            appendWriter.write(result + System.lineSeparator());
            appendWriter.close();

            System.out.println("All done ;)");
            return true;
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return false;
        }
    }

    public boolean hasAFile(BazaDoc user){
        File fileDoc = new File(BAZA_PATH + user.getNameFile() + ".txt");
        return fileDoc.exists();
    }

    public void saveUserInfo(BazaDoc user) {
        try (FileWriter writer = new FileWriter(BAZA_PATH + user.getNameFile() + ".txt", true)) {
            writer.write(user.toString() + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error saving user info: " + e.getMessage());
        }
    }
}
