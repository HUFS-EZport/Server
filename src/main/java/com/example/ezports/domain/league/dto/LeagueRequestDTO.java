package com.example.ezports.domain.league.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LeagueRequestDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createLeague {
        private Long sportId;
        private String name;
        private String information;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class updateLeague {
        private String name;
        private String information;
    }

}
