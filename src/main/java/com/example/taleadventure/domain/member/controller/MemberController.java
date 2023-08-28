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

    private final TokenProvider tokenProvider;

    public MemberController(MemberService memberService, TokenProvider tokenProvider) {
        this.memberService = memberService;
        this.tokenProvider = tokenProvider;
    }

    @Operation(description = "[인증] 로그인 페이지 - 엑세스 토큰을 통한 로그인하기")
    @GetMapping("/auth/kakao")
    public ApiSuccessResponse<LoginResponseDto> login(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_OK, memberService.getUserInformation(token));
    }

    @Operation(description = "[인증] 나이 설정 페이지 - 초기 유저 나이 설정하기")
    @PatchMapping("/set/age")
    public ApiSuccessResponse<MemberInfoDto> setAge(HttpServletRequest request, @RequestBody Map<String,Integer> age){
        String token = request.getHeader("Authorization");
        Long memberId = tokenProvider.getUserPk(token);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_OK, memberService.setMemberAge(age.get("age"), memberId));
    }

    @Operation(description = "[인증] 이름과 나이 설정 페이지 - 초기 유저 이름과 나이 설정하기")
    @PatchMapping("/set/name-phone-number")
    public ApiSuccessResponse<MemberInfoDto> setNameAndPhoneNumber(HttpServletRequest request, @RequestBody MemberNameAndPhoneNumberDto memberNameAndPhoneNumberDto){
        String token = request.getHeader("Authorization");
        Long memberId = tokenProvider.getUserPk(token);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_OK, memberService.setMemberNameAndPhoneNumber(memberNameAndPhoneNumberDto, memberId));
    }

    @Operation(description = "[인증] 회원 정보 수정 페이지 - 회원 정보 수정하기")
    @PatchMapping("/update-member")
    public ApiSuccessResponse<MemberInfoDto> updateMember(HttpServletRequest request, @RequestBody MemberInfoDto memberInfoDto){
        String token = request.getHeader("Authorization");
        Long memberId = tokenProvider.getUserPk(token);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_OK, memberService.updateMember(memberInfoDto, memberId));
    }

    @Operation(description = "[인증] 회원 탈퇴 페이지 - 회원 탈퇴하기")
    @DeleteMapping("/delete-member")
    public ApiSuccessResponse<String> deleteMember(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        Long memberId = tokenProvider.getUserPk(token);
        memberService.deleteMember(memberId);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_DELETE_MEMBER);
    }
}
