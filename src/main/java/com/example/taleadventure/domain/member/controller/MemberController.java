package com.example.taleadventure.domain.member.controller;

import com.example.taleadventure.base.config.login.JwtHeaderUtil;
import com.example.taleadventure.base.dto.ApiExceptionResponse;
import com.example.taleadventure.base.dto.ApiSuccessResponse;
import com.example.taleadventure.base.error.exception.TaleAdventureException;
import com.example.taleadventure.base.success.SuccessResponseResult;
import com.example.taleadventure.domain.member.dto.LoginResponseDto;
import com.example.taleadventure.domain.member.dto.MemberInfoDto;
import com.example.taleadventure.domain.member.dto.MemberNameAndPhoneNumberDto;
import com.example.taleadventure.domain.member.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Api(tags = "Member Controller")
@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @Operation(description = "[인증] 나이 설정 페이지 - 초기 유저 나이 설정하기")
    @PatchMapping("/set/age")
    public ApiSuccessResponse<MemberInfoDto> setAge(HttpServletRequest request, @RequestBody Map<String,Integer> age){
        String token = JwtHeaderUtil.getAccessToken(request);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_OK, memberService.setMemberAge(age.get("age"), token));
    }

    @Operation(description = "[인증] 이름과 나이 설정 페이지 - 초기 유저 닉네임 설정하기")
    @PatchMapping("/set/nickname")
    public ApiSuccessResponse<MemberInfoDto> setNickName(HttpServletRequest request, @RequestBody Map<String,String> nickName){
        String token = JwtHeaderUtil.getAccessToken(request);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_OK, memberService.setNickName(nickName.get("nickName"), token));
    }

    @Operation(description = "[인증] 회원 정보 수정 페이지 - 회원 정보 수정하기")
    @PatchMapping("/update")
    public ApiSuccessResponse<MemberInfoDto> updateMember(HttpServletRequest request, @RequestBody MemberInfoDto memberInfoDto){
        String token = JwtHeaderUtil.getAccessToken(request);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_OK, memberService.updateMember(memberInfoDto, token));
    }

    @Operation(description = "[인증] 회원 탈퇴 페이지 - 회원 탈퇴하기")
    @DeleteMapping("/delete")
    public ApiSuccessResponse<String> deleteMember(HttpServletRequest request){
        String token = JwtHeaderUtil.getAccessToken(request);
        memberService.deleteMember(token);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_DELETE_MEMBER);
    }
}
