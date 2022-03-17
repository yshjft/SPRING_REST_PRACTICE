package com.jerry.restpractice.domain.uesr.contorller.v1;

import com.jerry.restpractice.domain.uesr.dto.UserDto;
import com.jerry.restpractice.domain.uesr.dto.UsersDto;
import com.jerry.restpractice.domain.uesr.dto.UsersResponseDto;
import com.jerry.restpractice.domain.uesr.service.UserService;
import com.jerry.restpractice.global.common.response.ResponseDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    @ApiOperation(value="사용자 목록 조회", notes = "전체 사용자를 조회합니다.")
    public ResponseEntity<ResponseDto> getUsers() {
        UsersDto usersDto = userService.getUsers();

        // HATEOAS
        UsersResponseDto usersResponseDto = UsersResponseDto.builder()
                .total(usersDto.getTotal())
                .users(usersDto.getUsers().stream().map(userDto -> {
                    EntityModel entityModel = EntityModel.of(userDto);
                    entityModel.add(linkTo(methodOn(this.getClass()).getUser(userDto.getId())).withRel("get user(id: "+userDto.getId()+")"));
                    return entityModel;}).collect(Collectors.toList()))
                .build();

        ResponseDto responseDto = ResponseDto.builder()
                .status(HttpStatus.OK.value())
                .message("get all users")
                .result(usersResponseDto)
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDto);
    }


    @GetMapping("/{userId}")
    @ApiOperation(value="사용자 정보 상세 조회", notes = "userId에 해당되는 사용자 정보를 상세 조회합니다.")
    public ResponseEntity<ResponseDto> getUser(@PathVariable Long userId) {
        UserDto userDto = userService.getUser(userId);

        // HATEOAS
        EntityModel entityModel = EntityModel.of(userDto);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getUsers());
        entityModel.add(linkTo.withRel("get all users"));

        ResponseDto responseDto = ResponseDto.builder()
                .status(HttpStatus.OK.value())
                .message("get user")
                .result(entityModel)
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDto);
    }
}
