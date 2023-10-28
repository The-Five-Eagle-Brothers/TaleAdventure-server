package com.example.taleadventure.domain.member.dto;

import lombok.*;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SavePointDto {
    String taleBookName;
    String status;
}
