package com.jerry.restpractice.domain.uesr.service;

import com.jerry.restpractice.domain.uesr.dao.UserDao;
import com.jerry.restpractice.domain.uesr.domain.User;
import com.jerry.restpractice.domain.uesr.dto.UserDto;
import com.jerry.restpractice.domain.uesr.dto.UsersDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    public UserDto getUser(Long userId) {
        User user = UserDao.getUser(userId).orElse(null);

        if(user == null) {
            return null;
        }else{
            return UserDto.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .birthDate(user.getBirthDate())
                    .address(user.getAddress())
                    .build();
        }
    }

    public UsersDto getUsers() {
        List<User> users = UserDao.getUsers();

        return UsersDto.builder()
                .total(users.size())
                .users(users.stream()
                        .map(user ->
                        UserDto.builder()
                                .id(user.getId())
                                .name(user.getName())
                                .birthDate(user.getBirthDate())
                                .address(user.getAddress())
                        .build())
                        .collect(Collectors.toList())
                ).build();
    }
}
