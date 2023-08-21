package com.example.taleadventure.base.config.login;

import com.example.taleadventure.domain.member.entity.Member;
import com.example.taleadventure.domain.member.enummerate.Status;
import com.example.taleadventure.domain.member.repository.MemberRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class TokenProvider {

    private final MemberRepository memberRepository;

    public Long getUserPk(String token) {
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
        Member originMember = memberRepository.findByEmail(kakaoMember.getEmail()).get();

        return originMember.getId();
    }
}
