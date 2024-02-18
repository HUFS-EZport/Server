package com.example.ezports.domain.mapping.favourite.service;

import com.example.ezports.domain.league.entity.League;
import com.example.ezports.domain.league.service.LeagueQueryService;
import com.example.ezports.domain.mapping.favourite.converter.FavouriteConverter;
import com.example.ezports.domain.mapping.favourite.dto.FavouriteResponseDTO;
import com.example.ezports.domain.mapping.favourite.entity.FavouriteLeague;
import com.example.ezports.domain.mapping.favourite.entity.FavouriteTeam;
import com.example.ezports.domain.member.auth.utils.MemberUtils;
import com.example.ezports.domain.member.entity.Member;
import com.example.ezports.domain.member.service.MemberQueryService;
import com.example.ezports.domain.team.entity.Team;
import com.example.ezports.domain.team.service.TeamQueryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FavouriteService {
    private final FavouriteCommandService favouriteCommandService;
    private final FavouriteQueryService favouriteQueryService;
    private final FavouriteConverter favouriteConverter;
    private final MemberQueryService memberQueryService;
    private final TeamQueryService teamQueryService;
    private final LeagueQueryService leagueQueryService;
    private final MemberUtils memberUtils;

    @Transactional
    public void addFavouriteTeam(Long teamId) {
        Long memberId = memberUtils.getCurrentMemberId();
        Optional<FavouriteTeam> favouriteTeamOptional = favouriteQueryService.findByMemberIdAndTeamId(memberId, teamId);
        if (!favouriteTeamOptional.isPresent()) {
            Member member = memberQueryService.getMember(memberId);
            Team team = teamQueryService.getTeam(teamId);
            FavouriteTeam favouriteTeam = favouriteConverter.toFavouriteTeam(member, team);
            favouriteCommandService.createFavouriteTeam(favouriteTeam);
        } else {
            favouriteCommandService.deleteFavouriteTeam(favouriteTeamOptional.get());
        }
    }

    @Transactional
    public List<FavouriteResponseDTO.favouriteTeam> getFavouriteTeams() {
        Long memberId = memberUtils.getCurrentMemberId();
        List<FavouriteTeam> favouriteTeams = favouriteQueryService.getFavouriteTeams(memberId);
        List<FavouriteResponseDTO.favouriteTeam> favouriteTeamDTOs = favouriteConverter.toFavouriteTeams(favouriteTeams);
        return favouriteTeamDTOs;
    }

    @Transactional
    public void addFavouriteLeague(Long leagueId) {
        Long memberId = memberUtils.getCurrentMemberId();
        Optional<FavouriteLeague> favouriteLeagueOptional = favouriteQueryService.findByMemberIdAndLeagueId(memberId, leagueId);
        if (!favouriteLeagueOptional.isPresent()) {
            Member member = memberQueryService.getMember(memberId);
            League league = leagueQueryService.getLeague(leagueId);
            FavouriteLeague favouriteLeague = favouriteConverter.toFavouriteLeague(member, league);
            favouriteCommandService.createFavouriteLeague(favouriteLeague);
        } else {
            favouriteCommandService.deleteFavouriteLeague(favouriteLeagueOptional.get());
        }
    }

    @Transactional
    public List<FavouriteResponseDTO.favouriteLeague> getFavouriteLeagues() {
        Long memberId = memberUtils.getCurrentMemberId();
        List<FavouriteLeague> favouriteLeagues = favouriteQueryService.getFavouriteLeagues(memberId);
        List<FavouriteResponseDTO.favouriteLeague> favouriteLeagueDTOs = favouriteConverter.toFavouriteLeagues(favouriteLeagues);
        return favouriteLeagueDTOs;
    }
}
