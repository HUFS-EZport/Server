package com.example.ezports.domain.sport.dto;

import com.example.ezports.domain.league.dto.LeagueResponseDTO;
import com.example.ezports.domain.team.dto.TeamResponseDTO;
import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class SportResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createSport {
        private Long id;
        private String name;
        private String imageUrl;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getSport {
        private Long id;
        private String name;
        private String imageUrl;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getSportInfo {
        private List<TeamResponseDTO.getParticipantTeam> teams;
        private List<LeagueResponseDTO.getLeagues> leagues;
    }
}
