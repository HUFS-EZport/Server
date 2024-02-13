package com.example.ezports.domain.team.dto;

import com.example.ezports.domain.league.dto.LeagueResponseDTO;
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
    public static class getTeam {
        private Long id;
        private String name;
        private String information;
        private List<LeagueResponseDTO.getLeagues> leagues;
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
