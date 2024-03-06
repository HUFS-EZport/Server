package com.example.ezports.domain.member.service;

import com.example.ezports.domain.member.controller.MemberController;
import com.example.ezports.domain.member.converter.MemberConverter;
import com.example.ezports.domain.member.dto.MemberRequestDTO;
import com.example.ezports.domain.member.dto.MemberResponseDTO;
import com.example.ezports.domain.member.entity.Member;
import com.example.ezports.global.exception.GlobalErrorCode;
import com.example.ezports.global.jwt.JwtTokenService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MemberService {
    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;
    private final MemberConverter memberConverter;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenService jwtTokenService;

    @Transactional
    public MemberResponseDTO.createMember createMember(MemberRequestDTO.createMember request) {
        Member member = memberConverter.toMember(request.getEmail(), request.getPassword(), request.getNickname());
        Member savedMember = memberCommandService.createMember(member);
        return memberConverter.toCreateMember(savedMember);
    }

    @Transactional
    public MemberResponseDTO.login login(MemberRequestDTO.login request) {
        String email = request.getEmail();
        String password = request.getPassword();

        memberQueryService.getMemberByEmail(email); // UserId Notfound 예외처리용

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(email, password);
        System.out.println("authenticationToken = " + authenticationToken);
        System.out.println("object = " + authenticationManagerBuilder.getObject());


        Authentication authentication =
                authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        String role =
                authentication.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.joining(",")); // role_admin
        String authenticatedUserId = authentication.getName(); //  UserId

        Member member = memberQueryService.getMember(Long.valueOf(authenticatedUserId));
        String accessToken = jwtTokenService.generateAccessToken(member.getId(), role);
        String refreshToken = jwtTokenService.generateRefreshToken(member.getId());

        return memberConverter.toLogin(member, accessToken, refreshToken);
    }

    @Transactional
    public MemberResponseDTO.getMember getMember(Long memberId) {
        Member member = memberQueryService.getMember(memberId);
        return memberConverter.toGetMember(member);
    }

    @Transactional
    public List<MemberResponseDTO.getMember> getMembers() {
        List<Member> members = memberQueryService.getMembers();
        return memberConverter.toGetMembers(members);
    }

    @Transactional
    public void changePassword(Long memberId, MemberRequestDTO.changePassword request) {
        Member member = memberQueryService.getMember(memberId);
        member.changePassword(request.getPassword());
    }

    @Transactional
    public void withdraw(Long memberId) {
        Member member = memberQueryService.getMember(memberId);
        memberCommandService.withdraw(member);
    }

    @Transactional
    public MemberResponseDTO.reissue reissue(MemberRequestDTO.reissue request) {
        String refreshToken = request.getRefreshToken();

        Long memberId = jwtTokenService.parseRefreshToken(refreshToken);
        Member member = memberQueryService.getMember(memberId);
        String role = member.getRole().name();
        String newAccessToken = jwtTokenService.generateAccessToken(member.getId(), role);
        String newRefreshToken = jwtTokenService.generateRefreshToken(member.getId());

        return memberConverter.toReissue(memberId, newAccessToken, newRefreshToken);
    }
}
