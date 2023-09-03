package com.example.taleadventure.domain.chapter.controller;

import com.example.taleadventure.base.config.login.JwtHeaderUtil;
import com.example.taleadventure.base.dto.ApiSuccessResponse;
import com.example.taleadventure.base.success.SuccessResponseResult;
import com.example.taleadventure.domain.chapter.dto.ChapterInfoDto;
import com.example.taleadventure.domain.chapter.dto.ChapterRequest;
import com.example.taleadventure.domain.talebook.dto.TaleBookInfoDto;
import com.example.taleadventure.domain.talebook.dto.TaleBookRequest;
import com.example.taleadventure.domain.talebook.service.TaleBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chapter")
public class ChapterController {

    private final ChapterService chapterService;

    @PostMapping("/save")
    public ApiSuccessResponse<ChapterInfoDto> saveTaleBook(HttpServletRequest request, ChapterRequest chapterRequest, MultipartFile multipartFile){
        String token = JwtHeaderUtil.getAccessToken(request);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_CREATED, chapterService.saveChapter(chapterRequest, multipartFile));
    }
}
