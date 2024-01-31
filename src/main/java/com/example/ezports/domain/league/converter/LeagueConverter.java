package com.example.ezports.domain.league.converter;

import com.example.ezports.domain.league.dto.LeagueResponseDTO;
import com.example.ezports.domain.league.entity.League;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class LeagueConverter {
    public League toLeague(String leagueName, String information) {
        return League.builder()
                .name(leagueName)
                .information(information)
                .build();
    }

    public LeagueResponseDTO.createLeague toCreateLeague(League league) {
        return LeagueResponseDTO.createLeague.builder()
                .id(league.getId())
                .name(league.getName())
                .information(league.getInformation())
                .build();
    }

    public LeagueResponseDTO.getLeague toGetLeague(League league) {
        return LeagueResponseDTO.getLeague.builder()
                .id(league.getId())
                .name(league.getName())
                .information(league.getInformation())
                .build();
    }
}
