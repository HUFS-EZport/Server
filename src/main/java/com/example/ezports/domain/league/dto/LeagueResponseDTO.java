package com.example.ezports.domain.league.dto;

import com.example.ezports.domain.mapping.entity.Participant;
import com.example.ezports.domain.match.dto.MatchResponseDTO;
import com.example.ezports.domain.match.entity.Match;
import com.example.ezports.domain.team.dto.TeamResponseDTO;
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
    public static class getLeague {
        private Long id;
        private String name;
        private String information;
        private String logoUrl;
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
