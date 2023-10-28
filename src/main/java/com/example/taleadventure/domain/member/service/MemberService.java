package com.example.taleadventure.domain.member.service;

import com.example.taleadventure.domain.auth.service.AuthService;
import com.example.taleadventure.domain.member.dto.MemberInfoDto;
import com.example.taleadventure.domain.member.dto.SavePointDto;
import com.example.taleadventure.domain.member.entity.Member;
import com.example.taleadventure.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final AuthService authService;

    @Transactional
    public MemberInfoDto setMemberAge (Integer age, String token){
        Long memberId = authService.getMemberId(token);
        Member member = MemberServiceUtils.findById(memberRepository, memberId);
        member.setAge(age);
        return MemberInfoDto.of(memberRepository.save(member));
    }

    @Transactional
    public MemberInfoDto setNickname (String nickname, String token){
        Long memberId = authService.getMemberId(token);
        Member member = MemberServiceUtils.findById(memberRepository, memberId);
        member.updateNickname(nickname);
        return MemberInfoDto.of(memberRepository.save(member));
    }

    @Transactional
    public MemberInfoDto updateMember(MemberInfoDto memberInfoDto, String token){
        Long memberId = authService.getMemberId(token);
        Member member = MemberServiceUtils.findById(memberRepository, memberId);
        member.updateMember(memberInfoDto);
        return MemberInfoDto.of(memberRepository.save(member));
    }

    @Transactional
    public void deleteMember(String token){
        Long memberId = authService.getMemberId(token);
        memberRepository.delete(MemberServiceUtils.findById(memberRepository, memberId));
    }

    @Transactional
    public void increaseDay(String token){
        Long memberId = authService.getMemberId(token);
        Member member = MemberServiceUtils.findById(memberRepository, memberId);
        member.updateDay();
    }

    @Transactional
    public Integer checkMemberInfoValid(String token){
        Long memberId = authService.getMemberId(token);
        Member member = MemberServiceUtils.findById(memberRepository, memberId);
        return member.getAge();
    }

    @Transactional
    public void savePoint(String token, SavePointDto savePointDto){
        Long memberId = authService.getMemberId(token);
        Member member = MemberServiceUtils.findById(memberRepository, memberId);
        if(savePointDto.getTaleBookName().equals("어린왕자")){
            member.updateTheLittlePrinceStatus(savePointDto.getStatus());
        }else if(savePointDto.getTaleBookName().equals("토끼와 거북이")){
            member.updateRabbitAndTurtleStatus(savePointDto.getStatus());
        }
    }

    @Transactional
    public String retrievePoint(String token, String taleBookName){
        Long memberId = authService.getMemberId(token);
        Member member = MemberServiceUtils.findById(memberRepository, memberId);
        if(taleBookName.equals("어린왕자")){
            return member.getTheLittlePrinceStatus();
        }else if(taleBookName.equals("토끼와 거북이")){
            return member.getRabbitAndTurtleStatus();
        }else{
            return "존재하지 않는 동화입니다.";
        }
    }
}

