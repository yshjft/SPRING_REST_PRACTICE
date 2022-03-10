package com.jerry.restpractice.domain.uesr.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String address;

    @Builder
    public UserDto(Long id, String name, LocalDate birthDate, String address) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
    }
}
