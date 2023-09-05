package com.example.taleadventure.domain.home;

import com.example.taleadventure.base.config.login.JwtHeaderUtil;
import com.example.taleadventure.base.dto.ApiSuccessResponse;
import com.example.taleadventure.base.success.SuccessResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("/home")
public class HomeController {

    private final HomeService homeService;

    @Operation(description = "[인증] 홈 페이지 - 홈 뷰 보기")
    @GetMapping("/me")
    public ApiSuccessResponse<HomeResponse> showHome(HttpServletRequest request){
        String token = JwtHeaderUtil.getAccessToken(request);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_SEARCH_MY_HOME_VIEW, homeService.showHome(token););
    }
}
