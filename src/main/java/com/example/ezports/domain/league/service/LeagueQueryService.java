package com.example.ezports.domain.league.service;

import com.example.ezports.domain.league.entity.League;
import com.example.ezports.domain.league.repository.LeagueRepository;
import com.example.ezports.domain.sport.entity.Sport;
import com.example.ezports.global.exception.GeneralException;
import com.example.ezports.global.exception.GlobalErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeagueQueryService {
    private final LeagueRepository leagueRepository;

    public League getLeague(Long id) {
        return leagueRepository.findById(id)
                .orElseThrow(() -> new GeneralException(GlobalErrorCode.League_NOT_FOUND));
    }

    public List<League> getBySport(Sport sport) {
        return leagueRepository.findAllBySport(sport);
    }


}
