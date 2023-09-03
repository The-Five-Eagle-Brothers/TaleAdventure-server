package com.example.taleadventure.domain.talebook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaleBookRequest {
    private String name;
    private String categoru;
    private String imageUrl;
}
