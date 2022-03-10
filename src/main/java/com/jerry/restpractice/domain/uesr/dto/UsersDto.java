package com.jerry.restpractice.domain.uesr.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class UsersDto {
    private int total;
    private List<UserDto> users;

    @Builder
    public UsersDto(int total, List<UserDto> users) {
        this.total = total;
        this.users = users;
    }
}
