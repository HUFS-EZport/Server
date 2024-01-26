package com.example.ezports.domain.member.service;

import com.example.ezports.domain.member.controller.MemberController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberService {
    private final MemberCommandService commandService;
    private final MemberQueryService queryService;
}
