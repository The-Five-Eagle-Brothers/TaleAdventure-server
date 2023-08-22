package com.example.taleadventure.domain.member.dto;

import com.example.taleadventure.domain.member.entity.Member;
import lombok.*;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberInfoDto {
    private String name;
    private String nickName;
    private String phoneNumber;
    private String email;
    private String gender;
    private Integer age;
    private String status;

    public static MemberInfoDto of(Member member){
        return MemberInfoDto.builder()
                .name(member.getName())
                .nickName(member.getNickName())
                .phoneNumber(member.getPhoneNumber())
                .email(member.getEmail())
                .gender(Member.genderEnumToString(member.getGender()))
                .age(member.getAge())
                .status(Member.statusEnumToString(member.getStatus()))
                .build();
    }
}
