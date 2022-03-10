package com.jerry.restpractice.domain.uesr.contorller;

import com.jerry.restpractice.domain.uesr.dto.UserDto;
import com.jerry.restpractice.domain.uesr.dto.UsersDto;
import com.jerry.restpractice.domain.uesr.service.UserService;
import com.jerry.restpractice.global.common.response.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<ResponseDto> getUser(@PathVariable Long userId) {
        UserDto userDto= userService.getUser(userId);

        ResponseDto responseDto = ResponseDto.builder()
                .status(HttpStatus.OK.value())
                .message("get user")
                .result(userDto)
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDto);
    }

    @GetMapping
    public ResponseEntity<ResponseDto> getUser() {
        UsersDto usersDto = userService.getUsers();

        ResponseDto responseDto = ResponseDto.builder()
                .status(HttpStatus.OK.value())
                .message("get user")
                .result(usersDto)
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDto);
    }
}
