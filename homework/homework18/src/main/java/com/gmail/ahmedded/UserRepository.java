package com.gmail.ahmedded;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User(1, "Denchik", "iWantSleap@gmail.com"));
        users.add(new User(2, "Lobanov", "stupdSchool@gmail.com"));
        users.add(new User(3, "Kikot", "What@gmail.com"));
    }

    public Optional<User> findUserById(int id) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst();
    }

    public Optional<User> findUserByEmail(String email) {
        return users.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public Optional<List<User>> findAllUsers() {
        if (users.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(users);
    }
}

