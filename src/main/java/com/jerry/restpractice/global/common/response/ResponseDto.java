package com.jerry.restpractice.global.common.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@ApiModel(description = "응답")
public class ResponseDto <T>{
    @ApiModelProperty(example = "응답 상태")
    private int status;
    @ApiModelProperty(example = "응답 메시지")
    private String message;
    @ApiModelProperty(example = "응답 데이터")
    private T result;

    @Builder
    public ResponseDto(int status, String message, T result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }
}
