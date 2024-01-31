package com.example.ezports.domain.league.service;

import com.example.ezports.domain.league.repository.LeagueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeagueCommandService {
    private final LeagueRepository leagueRepository;
}
