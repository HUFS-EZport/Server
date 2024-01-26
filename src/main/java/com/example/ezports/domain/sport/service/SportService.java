package com.example.ezports.domain.sport.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SportService {
    private final SportCommandService sportCommandService;
    private final SportQueryService sportQueryService;
}
