package com.example.taleadventure.base.error;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorResponseResult {
    // 400 BAD_REQUEST

    // 401 UNAUTHORIZED

    // 403 FORBIDDEN

    // 404 NOT_FOUND

    // 405 METHOD_NOT_ALLOWED

    // 406 NOT_ACCEPTABLE

    // 409 CONFLICT

    // 415 UNSUPPORTED_MEDIA_TYPE

    // 500 INTERNAL_SERVER

    // 502 BAD_GATEWAY

    // 503 SERVICE_UNAVAILABLE

    private final ErrorStatusCode statusCode;
    private final String message;

    public int getStatus(){
        return statusCode.getStatus();
    }
}
