package com.example.taleadventure.domain.member.dto;

import lombok.*;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberNameAndPhoneNumberDto {
    private String name;
    private String phoneNumber;
}
