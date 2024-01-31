package com.example.ezports.domain.league.service;

import com.example.ezports.domain.league.converter.LeagueConverter;
import com.example.ezports.domain.league.dto.LeagueRequestDTO;
import com.example.ezports.domain.league.dto.LeagueResponseDTO;
import com.example.ezports.domain.league.entity.League;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LeagueService {
    private final LeagueCommandService leagueCommandService;
    private final LeagueQueryService leagueQueryService;
    private final LeagueConverter leagueConverter;

    @Transactional
    public LeagueResponseDTO.createLeague createLeague(LeagueRequestDTO.createLeague request) {
        League league = leagueConverter.toLeague(request.getName(), request.getInformation());
        League savedLeague = leagueCommandService.createLeague(league);
        return leagueConverter.toCreateLeague(savedLeague);
    }

    @Transactional
    public LeagueResponseDTO.getLeague getLeague(Long leagueId) {
        League league = leagueQueryService.getLeague(leagueId);
        return leagueConverter.toGetLeague(league);
    }

    @Transactional
    public void updateLeague(Long leagueId, LeagueRequestDTO.updateLeague request) {
        League league = leagueQueryService.getLeague(leagueId);
        league.updateLeague(request.getName(), request.getInformation());
    }

    @Transactional
    public void deleteLeague(Long leagueId) {
        League league = leagueQueryService.getLeague(leagueId);
        leagueCommandService.deleteLeague(league);
    }

}
