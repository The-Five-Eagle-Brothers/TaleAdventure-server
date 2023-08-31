package com.example.taleadventure.domain.member.service;

import com.example.taleadventure.domain.auth.service.AuthService;
import com.example.taleadventure.domain.member.dto.MemberInfoDto;
import com.example.taleadventure.domain.member.dto.MemberNameAndPhoneNumberDto;
import com.example.taleadventure.domain.member.entity.Member;
import com.example.taleadventure.domain.member.enummerate.Status;
import com.example.taleadventure.domain.member.repository.MemberRepository;
import com.example.taleadventure.domain.wordbook.entity.WordBook;
import com.example.taleadventure.domain.wordbook.repository.WordBookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

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
    public MemberInfoDto setNickName (String nickName, String token){
        Long memberId = authService.getMemberId(token);
        Member member = MemberServiceUtils.findById(memberRepository, memberId);
        member.updateNickName(nickName);
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

}

