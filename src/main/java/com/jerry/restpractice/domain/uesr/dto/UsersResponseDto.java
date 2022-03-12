package com.jerry.restpractice.domain.uesr.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.EntityModel;

import java.util.List;

@Getter
@NoArgsConstructor
public class UsersResponseDto {
    private int total;
    private List<EntityModel> users;

    @Builder
    public UsersResponseDto(int total, List<EntityModel> users) {
        this.total = total;
        this.users = users;
    }
}
