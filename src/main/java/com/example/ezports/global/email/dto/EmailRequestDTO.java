package com.example.ezports.global.email.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmailRequestDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class sendCode {
        private String email;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class verifyCode {
        private String email;
        private String code;
    }
}
