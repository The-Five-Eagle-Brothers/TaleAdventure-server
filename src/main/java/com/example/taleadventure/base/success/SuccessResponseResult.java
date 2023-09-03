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
    SUCCESS_CREATED(CREATED, "성공적으로 생성되었습니다."),
    SUCCESS_INCREASE_DAY(OK, "Day가 1일 증가됐습니다.");
    // 202 ACCEPTED

    // 204 NOT_CONTENT

    private final SuccessStatusCode statusCode;
    private final String message;

    private int getStatus(){
        return statusCode.getStatus();
    }
}
