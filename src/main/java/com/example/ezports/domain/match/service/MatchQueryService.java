package com.example.ezports.domain.match.service;

import com.example.ezports.domain.match.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatchQueryService {
    private final MatchRepository matchRepository;
}
