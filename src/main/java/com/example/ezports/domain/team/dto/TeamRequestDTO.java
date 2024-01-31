package com.example.ezports.domain.team.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class TeamRequestDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createTeam {
        private String name;
        private String information;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class updateTeam {
        private String name;
        private String information;
    }
}
