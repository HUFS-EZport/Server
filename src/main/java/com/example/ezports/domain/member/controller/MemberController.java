package com.example.ezports.domain.member.controller;

import com.example.ezports.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/signup")
    public void signUp() {
    }

    @PostMapping("/login")
    public void login() {
    }

    @GetMapping("/all")
    public void getMembers() {
    }

    @GetMapping
    public void getMember(
            @PathVariable Long memberId;
    ) {
    }

    @PatchMapping
    public void withdraw(
            @PathVariable Long memberId;
    ) {
    }

}
