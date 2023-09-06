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
    SUCCESS_SEARCH_MY_HOME_VIEW(OK, "홈 뷰를 조회했습니다."),
    SUCCESS_SEARCH_TALE_BOOK(OK, "동화책들을 조회했습니다."),
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
