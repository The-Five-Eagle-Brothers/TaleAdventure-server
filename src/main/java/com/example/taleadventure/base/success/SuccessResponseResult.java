package com.example.taleadventure.base.success;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static com.example.taleadventure.base.success.SuccessStatusCode.CREATED;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessResponseResult {
    // 200 OK

    // 201 CREATED
    SUCCESS_CREATED(CREATED, "");
    // 202 ACCEPTED

    // 204 NOT_CONTENT

    private final SuccessStatusCode successStatusCode;
    private final String message;

    private int getStatus(){
        return successStatusCode.getStatus();
    }
}
