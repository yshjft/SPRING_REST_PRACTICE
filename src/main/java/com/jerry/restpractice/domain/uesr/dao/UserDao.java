package com.jerry.restpractice.domain.uesr.dao;

import com.jerry.restpractice.domain.uesr.domain.User;
import com.jerry.restpractice.global.database.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserDao {
    public static Optional<User> getUser(Long id) {
        User user = null;

        for(User u : Data.users) {
            if(u.getId() == id) {
                user = u;
                break;
            }
        }

        return Optional.ofNullable(user);
    }

    public static List<User> getUsers() {
        List<User> users = Data.users;

        return users;
    }
}
