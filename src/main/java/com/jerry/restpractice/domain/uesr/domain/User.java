package com.jerry.restpractice.domain.uesr.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String address;

    @Builder
    public User(Long id, String name, LocalDate birthDate, String address) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
    }
}
