package com.example.taleadventure.domain.auth.service;

import com.example.taleadventure.base.config.login.AuthToken;
import com.example.taleadventure.base.config.login.AuthTokenProvider;
import com.example.taleadventure.base.config.login.ClientKaKao;
import com.example.taleadventure.base.error.ErrorResponseResult;
import com.example.taleadventure.base.error.exception.NotFoundException;
import com.example.taleadventure.domain.auth.dto.AuthRequest;
import com.example.taleadventure.domain.auth.dto.AuthResponse;
import com.example.taleadventure.domain.member.dto.LoginResponseDto;
import com.example.taleadventure.domain.member.entity.Member;
import com.example.taleadventure.domain.member.repository.MemberRepository;
import com.example.taleadventure.domain.member.service.MemberService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    private final MemberRepository memberRepository;
    private final ClientKaKao clientKaKao;
    private final AuthTokenProvider authTokenProvider;

    public AuthService(ClientKaKao clientKaKao, MemberRepository memberRepository, AuthTokenProvider authTokenProvider) {
        this.clientKaKao = clientKaKao;
        this.memberRepository = memberRepository;
        this.authTokenProvider = authTokenProvider;
    }


    @Transactional
    public AuthResponse login(AuthRequest authRequest){
        Member kakaoMember = clientKaKao.getUserData(authRequest.getAccessToken());
        String socialId = kakaoMember.getSocialId();
        Member member = memberRepository.findBySocialId(socialId);

        AuthToken appToken = authTokenProvider.createUserAppToken(socialId);

        if(member == null){
            memberRepository.save(kakaoMember);
        }

        return AuthResponse.builder()
                .appToken(appToken.getToken())
                .build();

    }

    public Long getMemberId(String token){
        AuthToken authToken = authTokenProvider.convertAuthToken(token);

        Claims claims = authToken.getTokenClaims();
        if(claims == null){
            return null;
        }
        try{
            Member member = memberRepository.findBySocialId(claims.getSubject());
            return member.getId();
        }catch (NotFoundException e){
            throw new NotFoundException(String.format("존재하지 않는 유저입니다."), ErrorResponseResult.NOT_FOUND_USER_EXCEPTION);
        }
    }
}
