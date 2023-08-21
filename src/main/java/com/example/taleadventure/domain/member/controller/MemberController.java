package com.example.taleadventure.domain.member.controller;

import com.example.taleadventure.base.config.login.TokenProvider;
import com.example.taleadventure.base.dto.ApiExceptionResponse;
import com.example.taleadventure.base.dto.ApiSuccessResponse;
import com.example.taleadventure.base.error.exception.TaleAdventureException;
import com.example.taleadventure.base.success.SuccessResponseResult;
import com.example.taleadventure.domain.member.dto.LoginResponseDto;
import com.example.taleadventure.domain.member.dto.MemberInfoDto;
import com.example.taleadventure.domain.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private TokenProvider tokenProvider;

    @GetMapping("/auth/kakao")
    public ApiSuccessResponse<LoginResponseDto> login(String code){
        String token = memberService.getToken(code);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_OK, memberService.getUserInformation(token));
    }

    @PatchMapping("/age")
    public ApiSuccessResponse<MemberInfoDto> setAge(HttpServletRequest request, @RequestBody Integer age){
        String token = request.getHeader("Authorization");
        Long memberId = tokenProvider.getUserPk(token);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_OK, memberService.setMemberAge(age, memberId));
    }

}
