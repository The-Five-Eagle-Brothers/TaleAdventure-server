package com.example.taleadventure.domain.auth.controller;

import com.example.taleadventure.base.dto.ApiSuccessResponse;
import com.example.taleadventure.base.success.SuccessResponseResult;
import com.example.taleadventure.domain.auth.dto.AuthRequest;
import com.example.taleadventure.domain.auth.dto.AuthResponse;
import com.example.taleadventure.domain.auth.service.AuthService;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "Auth Controller")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Operation(description = "[인증] 로그인 페이지 - 엑세스 토큰을 통한 로그인하기")
    @PostMapping(value = "/kakao")
    public ApiSuccessResponse<AuthResponse> login(@RequestBody AuthRequest authRequest){
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_OK, authService.login(authRequest));
    }
}
