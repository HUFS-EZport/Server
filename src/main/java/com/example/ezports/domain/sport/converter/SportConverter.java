package com.example.ezports.domain.sport.converter;

import com.example.ezports.domain.league.dto.LeagueResponseDTO;
import com.example.ezports.domain.sport.dto.SportResponseDTO;
import com.example.ezports.domain.sport.entity.Sport;
import com.example.ezports.domain.team.dto.TeamResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SportConverter {

    public Sport toSport(String sportName, String imageUrl) {
        return Sport.builder()
                .name(sportName)
                .imageUrl(imageUrl)
                .build();
    }

    public SportResponseDTO.createSport toCreateSport(Sport sport) {
        return SportResponseDTO.createSport.builder()
                .id(sport.getId())
                .name(sport.getName())
                .imageUrl(sport.getImageUrl())
                .build();
    }

    public SportResponseDTO.getSport toGetSport(Sport sport) {
        return SportResponseDTO.getSport.builder()
                .id(sport.getId())
                .name(sport.getName())
                .build();
    }
    public List<SportResponseDTO.getSport> toGetSports(List<Sport> sports) {
        return sports.stream()
                .map(this::toGetSport)
                .collect(Collectors.toList());
    }

    public SportResponseDTO.getSportInfo toGetSportInfo(Sport sport, List<TeamResponseDTO.getParticipantTeam> teams, List<LeagueResponseDTO.getLeagues> leagues) {
        return SportResponseDTO.getSportInfo.builder()
                .teams(teams)
                .leagues(leagues)
                .build();
    }
}

