package com.example.ezports.domain.match.dto;

import com.example.ezports.domain.match.entity.MatchStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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
        private LocalDateTime matchDate;
        private MatchStatus matchStatus;
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
        private String homeTeamLogoUrl;
        private String awayTeamLogoUrl;
        private String location;
        private LocalDateTime matchDate;
        private MatchStatus matchStatus;
        private List<String> streamingUrls;
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
        private LocalDateTime matchDate;
        private MatchStatus matchStatus;

    }

}
