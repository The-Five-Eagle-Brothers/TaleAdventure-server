package com.example.taleadventure.domain.word.controller;

import com.example.taleadventure.base.config.login.JwtHeaderUtil;
import com.example.taleadventure.base.dto.ApiSuccessResponse;
import com.example.taleadventure.base.success.SuccessResponseResult;
import com.example.taleadventure.domain.chapter.dto.ChapterInfoDto;
import com.example.taleadventure.domain.chapter.dto.ChapterRequest;
import com.example.taleadventure.domain.chapter.service.ChapterService;
import com.example.taleadventure.domain.word.dto.WordInfoDto;
import com.example.taleadventure.domain.word.dto.WordRequest;
import com.example.taleadventure.domain.word.service.WordService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/word")
public class WordController {

    private final WordService wordService;

    @PostMapping("/save")
    public ApiSuccessResponse<WordInfoDto> saveWord(HttpServletRequest request, WordRequest wordRequest, MultipartFile multipartFile){
        String token = JwtHeaderUtil.getAccessToken(request);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_CREATED, wordService.saveWord(wordRequest, multipartFile));
    }

    @Operation(description = "[인증] 단어 페이지 - 단어 조회하기")
    @GetMapping("/retrieve")
    public ApiSuccessResponse<List<WordInfoDto>> retrieveWord(HttpServletRequest request, @RequestParam String title){
        String token = JwtHeaderUtil.getAccessToken(request);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_SEARCH_WORD, wordService.retrieveWord(title, token));
    }

    @Operation(description = "[인증] 단어 페이지 - 단어 학습 후 최종 페이지에서 단어의 북마크 업데이트 하기")
    @PatchMapping("/update/book-mark")
    public ApiSuccessResponse<String> updateBookMark(HttpServletRequest request, List<WordInfoDto> wordInfoDtos){
        String token = JwtHeaderUtil.getAccessToken(request);
        wordService.updateBookMark(wordInfoDtos, token);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_UPDATE_WORD_BOOKMARK);
    }

    @Operation(description = "[인증] 단어 페이지 - 북마크한 단어 조회하기")
    @GetMapping("/retrieve/book-mark")
    public ApiSuccessResponse<List<WordInfoDto>> retrieveWord(HttpServletRequest request, @RequestParam String name){
        String token = JwtHeaderUtil.getAccessToken(request);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_RETRIEVE_BOOK_MARK_WORD, wordService.retrieveBookMarkWord(name, token));
    }
}
