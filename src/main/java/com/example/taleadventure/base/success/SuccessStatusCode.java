package com.example.taleadventure.base.success;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessStatusCode {
    OK(200),
    CREATED(201),
    ACCEPTED(202),
    NO_CONTENT(204);

    private final int status;
}
