package com.gmail.ahmedded;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserRepository repo = new UserRepository();

        Optional<User> user1 = repo.findUserById(2);
        if (user1.isPresent()) {
            System.out.println("Found for email: " + user1.get());
        } else {
            System.out.println("No one");
        }

        Optional<User> user2 = repo.findUserByEmail("iWantSleap@gmail.com");
        if (user2.isPresent()) {
            System.out.println("Found dor email : " + user2.get());
        } else {
            System.out.println("No one");
        }

        Optional<List<User>> all = repo.findAllUsers();
        if (all.isPresent()) {
            System.out.println("All polz: " + all.get().size());
        } else {
            System.out.println("No one");
        }
    }
}

