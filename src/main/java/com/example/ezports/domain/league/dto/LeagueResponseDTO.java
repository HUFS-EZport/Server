package com.example.ezports.domain.league.dto;

import com.example.ezports.domain.mapping.entity.Participant;
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
        private List<String> teamNames;
    }


}
