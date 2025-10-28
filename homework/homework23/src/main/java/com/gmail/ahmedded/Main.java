package com.gmail.ahmedded;

public class Main {
    public static void main(String[] args) {
        int length = 12;
        String password = PasswordGenerator.generatePassword(length);
        System.out.println("Пароль - " + password);
    }
}

