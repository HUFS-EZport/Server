package com.example.ezports.domain.member.controller;

import com.example.ezports.domain.member.dto.MemberRequestDTO;
import com.example.ezports.domain.member.dto.MemberResponseDTO;
import com.example.ezports.domain.member.service.MemberService;
import com.example.ezports.global.common.ApiResponse;
import com.example.ezports.global.email.EmailService;
import com.example.ezports.global.email.dto.EmailRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final EmailService emailService;

    @PostMapping("/email/code")
    public ApiResponse sendEmailCode(
            @RequestBody EmailRequestDTO.sendCode request
    ) {
        emailService.joinEmail(request.getEmail());
        return ApiResponse.onSuccess("");
    }

    @PostMapping("/email/verify")
    public ApiResponse verifyEmailCode(
            @RequestBody EmailRequestDTO.verifyCode request
    ) {
        emailService.checkCode(request.getEmail(), request.getCode());
        return ApiResponse.onSuccess("");
    }
    @PostMapping("/signup")
    public ApiResponse<MemberResponseDTO.createMember> signUp(
            @RequestBody MemberRequestDTO.createMember request
    ) {
        return ApiResponse.onSuccess(memberService.createMember(request));
    }

    @PostMapping("/login")
    public ApiResponse<MemberResponseDTO.login> login(
            @RequestBody MemberRequestDTO.login request
    ) {
        return ApiResponse.onSuccess(memberService.login(request));
    }

    @PostMapping("/reissue")
    public ApiResponse<MemberResponseDTO.reissue> reissue(
            @RequestBody MemberRequestDTO.reissue request
    ) {
        return ApiResponse.onSuccess(memberService.reissue(request));
    }

    @GetMapping("/all")
    public ApiResponse<List<MemberResponseDTO.getMember>> getMembers() {
        return ApiResponse.onSuccess(memberService.getMembers());
    }

    @GetMapping("/{memberId}")
    public ApiResponse<MemberResponseDTO.getMember> getMember(
            @PathVariable Long memberId
    ) {
        return ApiResponse.onSuccess(memberService.getMember(memberId));
    }

    @PatchMapping("/{memberId}")
    public ApiResponse withdraw(
            @PathVariable Long memberId
    ) {
        memberService.withdraw(memberId);
        return ApiResponse.onSuccess("");
    }

}
