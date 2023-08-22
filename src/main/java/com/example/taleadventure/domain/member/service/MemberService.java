package com.example.taleadventure.domain.member.service;

import com.example.taleadventure.base.config.login.KakaoProfile;
import com.example.taleadventure.base.config.login.OAuthToken;
import com.example.taleadventure.base.error.exception.TaleAdventureException;
import com.example.taleadventure.domain.member.dto.LoginResponseDto;
import com.example.taleadventure.domain.member.dto.MemberInfoDto;
import com.example.taleadventure.domain.member.dto.MemberNameAndPhoneNumberDto;
import com.example.taleadventure.domain.member.entity.Member;
import com.example.taleadventure.domain.member.enummerate.Status;
import com.example.taleadventure.domain.member.repository.MemberRepository;
import com.example.taleadventure.domain.wordbook.entity.WordBook;
import com.example.taleadventure.domain.wordbook.repository.WordBookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class MemberService {

    @Value("${oauth.kakao.client-id}")
    private String clientId;
    private final MemberRepository memberRepository;

    @Autowired
    private final WordBookRepository wordBookRepository;

    public MemberService(MemberRepository memberRepository, WordBookRepository wordBookRepository) {
        this.memberRepository = memberRepository;
        this.wordBookRepository = wordBookRepository;
    }

    @Transactional
    public String getToken(String code) {
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type","authorization_code");
        params.add("client_id", clientId);
        params.add("redirect_uri", "http://localhost:8080/member/auth/kakao");
        params.add("code", code);

        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);

        ResponseEntity<String> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );

        ObjectMapper objectMapper = new ObjectMapper();
        OAuthToken oauthToken = null;
        try {
            oauthToken = objectMapper.readValue(response.getBody(), OAuthToken.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return oauthToken.getAccess_token();
    }

    @Transactional
    public LoginResponseDto getUserInformation(String token){
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest = new HttpEntity<>(headers);

        ResponseEntity<String> response = rt.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoProfileRequest,
                String.class
        );

        ObjectMapper objectMapper = new ObjectMapper();
        KakaoProfile kakaoProfile = null;
        try {
            kakaoProfile = objectMapper.readValue(response.getBody(), KakaoProfile.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Member kakaoMember = Member.builder()
                .nickName(kakaoProfile.getKakao_account().getProfile().nickname)
                .email(kakaoProfile.getKakao_account().email)
                .gender(Member.genderStringToEnum(kakaoProfile.getKakao_account().gender))
                .status(Status.ACTIVE)
                .build();

        // 가입자 혹은 비가입자 체크 후 처리
        Member originMember = memberRepository.findByEmail(kakaoMember.getEmail()).orElseGet(() -> {
            return new Member();
        });

        if(originMember.getEmail() == null){
            originMember = kakaoMember;

            WordBook wordBook = new WordBook();
            wordBookRepository.save(wordBook);

            originMember.setWordBook(wordBook);
            memberRepository.save(originMember);
            return LoginResponseDto.of(originMember, token);
        }else{
            return LoginResponseDto.of(originMember, token);
        }
    }

    @Transactional
    public MemberInfoDto setMemberAge (Integer age, Long memberId){
        Member member = MemberServiceUtils.findById(memberRepository, memberId);
        member.setAge(age);
        return MemberInfoDto.of(memberRepository.save(member));
    }

    @Transactional
    public MemberInfoDto setMemberNameAndPhoneNumber (MemberNameAndPhoneNumberDto memberNameAndPhoneNumberDto, Long memberId){
        Member member = MemberServiceUtils.findById(memberRepository, memberId);
        member.setName(memberNameAndPhoneNumberDto.getName());
        member.setPhoneNumber(memberNameAndPhoneNumberDto.getPhoneNumber());
        return MemberInfoDto.of(memberRepository.save(member));
    }

    @Transactional
    public MemberInfoDto updateMember(MemberInfoDto memberInfoDto, Long memberId){
        Member member = MemberServiceUtils.findById(memberRepository, memberId);
        member.updateMember(memberInfoDto);
        return MemberInfoDto.of(memberRepository.save(member));
    }

    @Transactional
    public void deleteMember(Long memberId){
        memberRepository.delete(MemberServiceUtils.findById(memberRepository, memberId));
    }

}

