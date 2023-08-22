package com.example.taleadventure.base.success;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static com.example.taleadventure.base.success.SuccessStatusCode.CREATED;
import static com.example.taleadventure.base.success.SuccessStatusCode.OK;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessResponseResult {
    // 200 OK
    SUCCESS_OK(OK, ""),
    SUCCESS_DELETE_MEMBER(OK, "회원 탈퇴가 완료되었습니다."),
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
