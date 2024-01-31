package com.example.ezports.domain.match.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MatchService {
    private final MatchCommandService matchCommandService;
    private final MatchQueryService matchQueryService;
}
