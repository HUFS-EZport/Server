package com.example.ezports.domain.sport.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class SportRequestDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createSport {
        private String name;
        private String imageUrl;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class updateSport {
        private String name;
    }
}
