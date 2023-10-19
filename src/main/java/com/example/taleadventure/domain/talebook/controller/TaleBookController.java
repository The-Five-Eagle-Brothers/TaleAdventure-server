package com.example.taleadventure.domain.talebook.controller;

import com.example.taleadventure.base.config.login.JwtHeaderUtil;
import com.example.taleadventure.base.dto.ApiSuccessResponse;
import com.example.taleadventure.base.success.SuccessResponseResult;
import com.example.taleadventure.domain.talebook.dto.TaleBookInfoDto;
import com.example.taleadventure.domain.talebook.dto.TaleBookRequest;
import com.example.taleadventure.domain.talebook.service.TaleBookService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/talebook")
@CrossOrigin(origins = "*")
public class TaleBookController {

    private final TaleBookService taleBookService;

    @PostMapping("/save")
    public ApiSuccessResponse<TaleBookInfoDto> saveTaleBook(HttpServletRequest request, @RequestPart TaleBookRequest taleBookRequest, @RequestPart List<MultipartFile> multipartFiles){
        String token = JwtHeaderUtil.getAccessToken(request);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_CREATED, taleBookService.saveTaleBook(taleBookRequest, multipartFiles));
    }

    @Operation(description = "[인증] 나만의 단어장 페이지 - 동화책 조회하기")
    @GetMapping("/retrieve")
    public ApiSuccessResponse<List<TaleBookInfoDto>> retrieveTaleBook(HttpServletRequest request){
        String token = JwtHeaderUtil.getAccessToken(request);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_SEARCH_TALE_BOOK, taleBookService.retrieveTaleBook(token));
    }
}
