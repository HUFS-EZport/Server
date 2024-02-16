package com.example.ezports.domain.mapping.favourite.converter;

import com.example.ezports.domain.league.entity.League;
import com.example.ezports.domain.mapping.favourite.dto.FavouriteResponseDTO;
import com.example.ezports.domain.mapping.favourite.entity.FavouriteLeague;
import com.example.ezports.domain.mapping.favourite.entity.FavouriteTeam;
import com.example.ezports.domain.member.entity.Member;
import com.example.ezports.domain.team.entity.Team;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FavouriteConverter {

    public FavouriteTeam toFavouriteTeam(Member member, Team team) {
        return FavouriteTeam.builder()
                .member(member)
                .team(team)
                .build();
    }

    public List<FavouriteResponseDTO.favouriteTeam> toFavouriteTeams(List<FavouriteTeam> favouriteTeams) {
        return favouriteTeams.stream()
                .map(favouriteTeam -> FavouriteResponseDTO.favouriteTeam.builder()
                        .teamId(favouriteTeam.getTeam().getId())
                        .teamName(favouriteTeam.getTeam().getName())
                        .logoUrl(favouriteTeam.getTeam().getLogoUrl())
                        .build())
                .collect(Collectors.toList());
    }

    public FavouriteLeague toFavouriteLeague(Member member, League league) {
        return FavouriteLeague.builder()
                .member(member)
                .league(league)
                .build();
    }

    public List<FavouriteResponseDTO.favouriteLeague> toFavouriteLeagues(List<FavouriteLeague> favouriteLeagues) {
        return favouriteLeagues.stream()
                .map(favouriteLeague -> FavouriteResponseDTO.favouriteLeague.builder()
                        .leagueId(favouriteLeague.getLeague().getId())
                        .leagueName(favouriteLeague.getLeague().getName())
                        .logoUrl(favouriteLeague.getLeague().getLogoUrl())
                        .build())
                .collect(Collectors.toList());
    }
}
