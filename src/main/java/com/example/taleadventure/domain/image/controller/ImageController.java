package com.example.taleadventure.domain.image.controller;

import com.example.taleadventure.base.dto.ApiSuccessResponse;
import com.example.taleadventure.base.success.SuccessResponseResult;
import com.example.taleadventure.domain.image.service.S3Upload;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/image")
@CrossOrigin(origins = "*")
public class ImageController {

    private final S3Upload s3Upload;

    @PostMapping("/upload")
    public ApiSuccessResponse<String> uploadFile (@RequestParam("images") MultipartFile multipartFile) throws IOException {
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_CREATED, s3Upload.upload(multipartFile));
    }
}
