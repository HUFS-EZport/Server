package com.example.ezports.domain.match.dto;

import com.example.ezports.domain.match.entity.MatchStatus;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class MatchResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createMatch {
        private Long id;
        private Long leagueId;
        private String homeTeamName;
        private String awayTeamName;
        private String location;
        private String matchDate;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getMatch {
        private Long id;
        private Long leagueId;
        private String homeTeamName;
        private String awayTeamName;
        private Integer homeTeamScore;
        private Integer awayTeamScore;
        private String location;
        private String matchDate;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getLeagueMatch {
        private Long id;
        private String homeTeamName;
        private String awayTeamName;
        private Integer homeTeamScore;
        private Integer awayTeamScore;
        private String matchDate;
        private MatchStatus matchStatus;
    }

}
