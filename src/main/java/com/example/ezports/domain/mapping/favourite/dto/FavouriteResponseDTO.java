package com.example.ezports.domain.mapping.favourite.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class FavouriteResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class favouriteTeam {
        private Long teamId;
        private String teamName;
        private String logoUrl;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class favouriteLeague {
        private Long leagueId;
        private String leagueName;
        private String logoUrl;
    }
}
