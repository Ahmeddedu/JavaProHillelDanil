package com.gmail.ahmedded.Project1Test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите username:");
        String username = scanner.nextLine();

        System.out.println("Введите password:");
        String password = scanner.nextLine();

        System.out.println("Введите age:");
        String age = scanner.nextLine();

        Token token = new Token(username, password, age);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(token);
            tx.commit();
            System.out.println("Токен успешно сохранён для пользователя: " + token.getUsername());
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.shutdown();
        }

        scanner.close();
        System.out.println("Программа завершена.");
    }
}
