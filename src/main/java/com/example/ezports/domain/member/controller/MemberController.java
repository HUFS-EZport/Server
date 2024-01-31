package com.example.ezports.domain.member.controller;

import com.example.ezports.domain.member.dto.MemberRequestDTO;
import com.example.ezports.domain.member.dto.MemberResponseDTO;
import com.example.ezports.domain.member.service.MemberService;
import com.example.ezports.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/signup")
    public ApiResponse<MemberResponseDTO.createMember> signUp(
            @RequestBody MemberRequestDTO.createMember request
    ) {
        return ApiResponse.onSuccess(memberService.createMember(request));
    }


    @PostMapping("/login")
    public void login() {
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
