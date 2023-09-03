package com.example.taleadventure.domain.member.entity;

import com.example.taleadventure.base.entity.AuditingTimeEntity;
import com.example.taleadventure.domain.member.dto.MemberInfoDto;
import com.example.taleadventure.domain.member.enummerate.Gender;
import com.example.taleadventure.domain.member.enummerate.Status;
import lombok.*;

import javax.persistence.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Member extends AuditingTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    private Integer age;

    @Column(nullable = false)
    private String socialId;

    @Column(nullable = false)
    private Integer day;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;


    public void setAge(Integer age){
        this.age = age;
    }

    public void setDay(){
        this.day = 1;
    }

    public void updateNickName(String nickName){
        this.nickName = nickName;
    }

    public void updateDay(){
        this.day++;
    }

    public static String genderEnumToString(Gender gender){
        if(gender == Gender.MALE){
            return "male";
        }else{
            return "female";
        }
    }

    public static Gender genderStringToEnum(String str){
        if(str.equals("male")){
            return Gender.MALE;
        }else{
            return Gender.FEMALE;
        }
    }

    public static String statusEnumToString(Status status){
        if(status == Status.ACTIVE){
            return "active";
        }else{
            return "inactive";
        }
    }

    public static Status statusStringToEnum(String str){
        if(str.equals("active")){
            return Status.ACTIVE;
        }else{
            return Status.INACTIVE;
        }
    }

    public void updateMember(MemberInfoDto memberInfoDto){
        this.nickName = memberInfoDto.getNickName();
        this.email = memberInfoDto.getEmail();
        this.gender = Member.genderStringToEnum(memberInfoDto.getGender());
        this.age = memberInfoDto.getAge();
        this.status = Member.statusStringToEnum(memberInfoDto.getStatus());
    }
}
