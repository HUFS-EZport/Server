package com.example.ezports.domain.match.service;

import com.example.ezports.domain.match.entity.Match;
import com.example.ezports.domain.match.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatchCommandService {
    private final MatchRepository matchRepository;

    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

public void deleteMatch(Match match) {
        matchRepository.delete(match);
    }

}
