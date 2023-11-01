package com.example.taleadventure.domain.notification.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class RequestDto {
    private String targetToken;
    private String title;
    private String body;
}
