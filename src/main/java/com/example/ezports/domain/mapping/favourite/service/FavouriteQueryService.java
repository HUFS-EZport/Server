package com.example.ezports.domain.mapping.favourite.service;

import com.example.ezports.domain.mapping.favourite.entity.FavouriteLeague;
import com.example.ezports.domain.mapping.favourite.entity.FavouriteTeam;
import com.example.ezports.domain.mapping.favourite.repository.FavouriteLeagueRepository;
import com.example.ezports.domain.mapping.favourite.repository.FavouriteTeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FavouriteQueryService {

    private final FavouriteTeamRepository favouriteTeamRepository;
    private final FavouriteLeagueRepository favouriteLeagueRepository;
    public boolean isFavouriteTeam(Long memberId, Long teamId) {
        return favouriteTeamRepository.existsByMember_IdAndTeam_Id(memberId, teamId);
    }

    public Optional<FavouriteTeam> findByMemberIdAndTeamId(Long memberId, Long teamId) {
        return favouriteTeamRepository.findByMember_IdAndTeam_Id(memberId, teamId);
    }

    public List<FavouriteTeam> getFavouriteTeams(Long memberId) {
        return favouriteTeamRepository.findAllByMember_Id(memberId);
    }

    public boolean isFavouriteLeague(Long memberId, Long leagueId) {
        return favouriteLeagueRepository.existsByMember_IdAndLeague_Id(memberId, leagueId);
    }

    public Optional<FavouriteLeague> findByMemberIdAndLeagueId(Long memberId, Long leagueId) {
        return favouriteLeagueRepository.findByMember_IdAndLeague_Id(memberId, leagueId);
    }

    public List<FavouriteLeague> getFavouriteLeagues(Long memberId) {
        return favouriteLeagueRepository.findAllByMember_Id(memberId);
    }
}
