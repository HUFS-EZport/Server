package com.example.ezports.domain.team.dto;

import com.example.ezports.domain.league.dto.LeagueResponseDTO;
import com.example.ezports.domain.match.dto.MatchResponseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class TeamResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createTeam {
        private Long id;
        private String name;
        private String information;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonPropertyOrder( {"id", "name", "information", "favourite", "leagues"} )
    public static class getTeam {
        private Long id;
        private String name;
        private String information;
        private String logoUrl;
        @Builder.Default
        private boolean isFavourite = false;
        private List<LeagueResponseDTO.getLeagues> leagues;
        private List<MatchResponseDTO.getTeamMatch> matches;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getParticipantTeam {
        private Long id;
        private String name;
        private String logoUrl;
    }
}
