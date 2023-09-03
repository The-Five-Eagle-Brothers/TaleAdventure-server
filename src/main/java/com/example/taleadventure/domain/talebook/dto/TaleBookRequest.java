package com.example.taleadventure.domain.talebook.dto;

import lombok.*;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaleBookRequest {
    private String name;
    private String category;
    private String imageUrl;
}
