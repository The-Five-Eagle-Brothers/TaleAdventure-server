package com.example.taleadventure.base.dto;

import com.example.taleadventure.base.error.ErrorResponseResult;
import com.example.taleadventure.base.error.ErrorStatusCode;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiExceptionResponse {

    private ErrorStatusCode statusCode;
    private int status;
    private String message;

    public static ApiExceptionResponse error(ErrorResponseResult errorResponseResult){
        return new ApiExceptionResponse(errorResponseResult.getStatusCode(), errorResponseResult.getStatus(), errorResponseResult.getMessage());
    }
}
