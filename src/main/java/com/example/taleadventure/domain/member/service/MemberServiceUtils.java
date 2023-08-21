package com.example.taleadventure.domain.member.service;

import com.example.taleadventure.base.error.ErrorResponseResult;
import com.example.taleadventure.base.error.exception.NotFoundException;
import com.example.taleadventure.domain.member.entity.Member;
import com.example.taleadventure.domain.member.repository.MemberRepository;

public class MemberServiceUtils {

    public static Member findById(MemberRepository memberRepository, Long userID){
        Member member = memberRepository.findById(userID).get();
        if(member == null){
            throw new NotFoundException(String.format("존재하지 않는 유저입니다."), ErrorResponseResult.NOT_FOUND_USER_EXCEPTION);
        }
        return member;
    }
}
