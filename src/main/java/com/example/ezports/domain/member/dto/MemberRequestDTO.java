package com.example.ezports.domain.member.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class MemberRequestDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createMember {
        private String email;
        private String password;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class changePassword {
        private String password;
    }
}
