package com.example.taleadventure.domain.talebook.controller;

import com.example.taleadventure.base.config.login.JwtHeaderUtil;
import com.example.taleadventure.base.dto.ApiSuccessResponse;
import com.example.taleadventure.base.success.SuccessResponseResult;
import com.example.taleadventure.domain.talebook.dto.TaleBookInfoDto;
import com.example.taleadventure.domain.talebook.dto.TaleBookRequest;
import com.example.taleadventure.domain.talebook.service.TaleBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/talebook")
public class TaleBookController {

    private final TaleBookService taleBookService;

    @PostMapping("/save")
    public ApiSuccessResponse<TaleBookInfoDto> saveTaleBook(HttpServletRequest request, TaleBookRequest taleBookRequest){
        String token = JwtHeaderUtil.getAccessToken(request);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_CREATED, taleBookService.saveTaleBook(taleBookRequest));
    }
}
