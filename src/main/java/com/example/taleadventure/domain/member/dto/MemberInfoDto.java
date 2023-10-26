package com.example.taleadventure.domain.member.dto;

import com.example.taleadventure.domain.member.entity.Member;
import lombok.*;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberInfoDto {
    private String nickname;
    private String email;
    private String gender;
    private Integer age;
    private Integer day;
    private String status;

    public static MemberInfoDto of(Member member){
        return MemberInfoDto.builder()
                .nickname(member.getNickname())
                .email(member.getEmail())
                .gender(Member.genderEnumToString(member.getGender()))
                .age(member.getAge())
                .day(member.getDay())
                .status(Member.statusEnumToString(member.getStatus()))
                .build();
    }
}
