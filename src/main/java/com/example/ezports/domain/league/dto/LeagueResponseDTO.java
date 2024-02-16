package com.example.ezports.domain.league.dto;

import com.example.ezports.domain.match.dto.MatchResponseDTO;
import com.example.ezports.domain.team.dto.TeamResponseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LeagueResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createLeague {
        private Long id;
        private String name;
        private String information;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonPropertyOrder( {"id", "name", "information", "favourite", "teams", "matches"} )
    public static class getLeague {
        private Long id;
        private String name;
        private String information;
        private String logoUrl;
        @Builder.Default
        private boolean isFavourite = false;
        private List<TeamResponseDTO.getParticipantTeam> teams;
        private List<MatchResponseDTO.getLeagueMatch> matches;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getLeagues {
        private Long id;
        private String name;
        private String logoUrl;
    }


}
