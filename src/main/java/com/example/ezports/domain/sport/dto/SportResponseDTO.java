package com.example.ezports.domain.sport.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class SportResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createSport {
        private Long id;
        private String name;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getSport {
        private Long id;
        private String name;
    }
}
