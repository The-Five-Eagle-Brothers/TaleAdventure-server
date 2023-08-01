package com.example.taleadventure.domain.member.controller;

import com.example.taleadventure.domain.member.entity.Member;
import com.example.taleadventure.domain.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/auth/kakao")
    public @ResponseBody String login(String code){
        String token = memberService.getToken(code);
        return memberService.getUserInformation(token);
    }

}
