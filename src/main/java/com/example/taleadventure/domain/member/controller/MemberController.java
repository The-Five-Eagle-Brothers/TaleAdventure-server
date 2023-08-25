package com.example.taleadventure.domain.member.controller;

import com.example.taleadventure.base.config.login.TokenProvider;
import com.example.taleadventure.base.dto.ApiExceptionResponse;
import com.example.taleadventure.base.dto.ApiSuccessResponse;
import com.example.taleadventure.base.error.exception.TaleAdventureException;
import com.example.taleadventure.base.success.SuccessResponseResult;
import com.example.taleadventure.domain.member.dto.LoginResponseDto;
import com.example.taleadventure.domain.member.dto.MemberInfoDto;
import com.example.taleadventure.domain.member.dto.MemberNameAndPhoneNumberDto;
import com.example.taleadventure.domain.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private TokenProvider tokenProvider;

    @GetMapping("/auth/kakao")
    public String login(@RequestParam(value = "code", required = false) String code){
        String token = memberService.getToken(code);
        return token;
    }

    @PatchMapping("/set/age")
    public ApiSuccessResponse<MemberInfoDto> setAge(HttpServletRequest request, @RequestBody Map<String,Integer> age){
        String token = request.getHeader("Authorization");
        Long memberId = tokenProvider.getUserPk(token);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_OK, memberService.setMemberAge(age.get("age"), memberId));
    }

    @PatchMapping("/set/name-phone-number")
    public ApiSuccessResponse<MemberInfoDto> setNameAndPhoneNumber(HttpServletRequest request, @RequestBody MemberNameAndPhoneNumberDto memberNameAndPhoneNumberDto){
        String token = request.getHeader("Authorization");
        Long memberId = tokenProvider.getUserPk(token);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_OK, memberService.setMemberNameAndPhoneNumber(memberNameAndPhoneNumberDto, memberId));
    }

    @PatchMapping("/update-member")
    public ApiSuccessResponse<MemberInfoDto> updateMember(HttpServletRequest request, @RequestBody MemberInfoDto memberInfoDto){
        String token = request.getHeader("Authorization");
        Long memberId = tokenProvider.getUserPk(token);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_OK, memberService.updateMember(memberInfoDto, memberId));
    }

    @DeleteMapping("/delete-member")
    public ApiSuccessResponse<String> deleteMember(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        Long memberId = tokenProvider.getUserPk(token);
        memberService.deleteMember(memberId);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_DELETE_MEMBER);
    }
}
