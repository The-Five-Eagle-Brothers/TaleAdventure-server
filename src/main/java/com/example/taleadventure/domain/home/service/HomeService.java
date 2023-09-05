package com.example.taleadventure.domain.home.service;

import com.example.taleadventure.domain.auth.service.AuthService;
import com.example.taleadventure.domain.home.dto.HomeResponseDto;
import com.example.taleadventure.domain.member.entity.Member;
import com.example.taleadventure.domain.member.repository.MemberRepository;
import com.example.taleadventure.domain.member.service.MemberServiceUtils;
import com.example.taleadventure.domain.talebook.entity.TaleBook;
import com.example.taleadventure.domain.talebook.repository.TaleBookRepository;
import com.example.taleadventure.domain.talebook.service.TaleBookServiceUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HomeService {

    private final TaleBookRepository taleBookRepository;
    private final MemberRepository memberRepository;
    private final AuthService authService;

    @Transactional
    public HomeResponseDto showHome(String token){
        Long memberId = authService.getMemberId(token);
        Member member = MemberServiceUtils.findById(memberRepository, memberId);
        List<TaleBook> taleBooks = TaleBookServiceUtils.findAll(taleBookRepository);
        return HomeResponseDto.of(member.getDay(), taleBooks);
    }
}
