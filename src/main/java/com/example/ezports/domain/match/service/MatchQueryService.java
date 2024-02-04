package com.example.ezports.domain.match.service;

import com.example.ezports.domain.league.entity.League;
import com.example.ezports.domain.match.entity.Match;
import com.example.ezports.domain.match.repository.MatchRepository;
import com.example.ezports.global.exception.GeneralException;
import com.example.ezports.global.exception.GlobalErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchQueryService {
    private final MatchRepository matchRepository;

    public Match getMatch(Long id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new GeneralException(GlobalErrorCode.MATCH_NOT_FOUND));
    }

    public List<Match> getByLeague(League league) {
        return matchRepository.findAllByLeague(league);
    }
}
