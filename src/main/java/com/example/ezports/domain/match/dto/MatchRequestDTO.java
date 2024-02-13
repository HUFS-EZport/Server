package com.example.ezports.domain.match.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class MatchRequestDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createMatch {
        private Long leagueId;
        private Long homeTeamId;
        private Long awayTeamId;
        private String location;
        private LocalDateTime matchDate;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class updateMatch {
        private String location;
        private LocalDateTime matchDate;
    }
}
